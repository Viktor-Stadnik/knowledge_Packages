package packages.service.mapper;

import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import packages.dto.request.KpacSetRequestDto;
import packages.dto.response.KpacSetResponseDto;
import packages.model.Kpac;
import packages.model.KpacSet;

@Component
public class KpacSetMapper {
    public KpacSetResponseDto mapToDto(KpacSet kpacSet) {
        KpacSetResponseDto responseDto = new KpacSetResponseDto();
        responseDto.setId(kpacSet.getId());
        responseDto.setTitle(kpacSet.getTitle());
        responseDto.setKpacsId(kpacSet.getKPacs()
                .stream()
                .map(Kpac::getId)
                .collect(Collectors.toList()));
        return responseDto;
    }

    public KpacSet mapToModel(KpacSetRequestDto kpacSetRequestDto) {
        KpacSet kpacSet = new KpacSet();
        kpacSet.setTitle(kpacSetRequestDto.getTitle());
        kpacSet.setKPacs(kpacSetRequestDto.getKpacs());
        return kpacSet;
    }
}
