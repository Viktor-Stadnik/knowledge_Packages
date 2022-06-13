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
import packages.dto.request.KpacRequestDto;
import packages.dto.response.KpacResponseDto;
import packages.service.KpacService;
import packages.service.mapper.KpacMapper;

@Controller
public class KpacController {
    private final KpacService kpacService;
    private final KpacMapper kpacMapper;

    public KpacController(KpacService kpacService,
                          KpacMapper kpacMapper) {
        this.kpacService = kpacService;
        this.kpacMapper = kpacMapper;
    }

    @RequestMapping("/addkpac")
    public String showKPac(Model model) {
        model.addAttribute("command", new KpacRequestDto());
        return "addkpac";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("kPac") @Valid KpacRequestDto kpacRequestDto,
                       BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addkpac";
        }
        kpacService.create(kpacMapper.mapToModel(kpacRequestDto));
        return "redirect:/kpacs";
    }

    @RequestMapping("/kpacs")
    public String viewKPac(Model model) {
        List<KpacResponseDto> list = kpacService.getAll().stream()
                .map(kpacMapper::mapToDto)
                .collect(Collectors.toList());
        model.addAttribute("list",list);
        return "kpacs";
    }

    @GetMapping("/deletekpac/{id}")
    public String delete(@PathVariable Long id) {
        kpacService.delete(id);
        return "redirect:/kpacs";
    }
}
