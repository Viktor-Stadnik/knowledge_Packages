package packages.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import packages.dto.request.KpacSetRequestDto;
import packages.dto.response.KpacSetResponseDto;
import packages.service.KpacService;
import packages.service.KpacSetService;
import packages.service.mapper.KpacSetMapper;

@Controller
public class KpacSetController {
    private final KpacSetService kpacSetService;
    private final KpacSetMapper kpacSetMapper;
    private final KpacService kpacService;

    public KpacSetController(KpacSetService kpacSetService,
                             KpacSetMapper kpacSetMapper,
                             KpacService kpacService) {
        this.kpacSetService = kpacSetService;
        this.kpacSetMapper = kpacSetMapper;
        this.kpacService = kpacService;
    }

    @RequestMapping("/addsets")
    public String showKPacSet(Model model) {
        model.addAttribute("command1", new KpacSetRequestDto());
        return "addsets";
    }

    @PostMapping("/saveSet")
    public String save(@ModelAttribute("kPacSet") @Valid KpacSetRequestDto kpacSetRequestDto,
                       BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addsets";
        }
        kpacSetService.create(kpacSetMapper.mapToModel(kpacSetRequestDto));
        return "redirect:/sets";
    }

    @RequestMapping("/sets")
    public String viewKPacSet(Model model) {
        List<KpacSetResponseDto> listSet = kpacSetService.getAll().stream()
                .map(kpacSetMapper::mapToDto)
                .collect(Collectors.toList());
        model.addAttribute("listSet",listSet);
        return "sets";
    }

    @GetMapping("/deletesets/{id}")
    public String deleteSets(@PathVariable Long id) {
        kpacSetService.delete(id);
        return "redirect:/sets";
    }
}
