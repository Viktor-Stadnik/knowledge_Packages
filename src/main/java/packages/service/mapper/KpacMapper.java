package packages.service.mapper;

import org.springframework.stereotype.Component;
import packages.dto.request.KpacRequestDto;
import packages.dto.response.KpacResponseDto;
import packages.model.Kpac;

@Component
public class KpacMapper {
    public KpacResponseDto mapToDto(Kpac kpac) {
        KpacResponseDto responseDto = new KpacResponseDto();
        responseDto.setId(kpac.getId());
        responseDto.setTitle(kpac.getTitle());
        responseDto.setDescription(kpac.getDescription());
        responseDto.setShowDate(kpac.getShowDate());
        return responseDto;
    }

    public Kpac mapToModel(KpacRequestDto kpacRequestDto) {
        Kpac kpac = new Kpac();
        kpac.setTitle(kpacRequestDto.getTitle());
        kpac.setDescription(kpacRequestDto.getDescription());
        kpac.setShowDate(kpacRequestDto.getShowDate());
        return kpac;
    }
}
