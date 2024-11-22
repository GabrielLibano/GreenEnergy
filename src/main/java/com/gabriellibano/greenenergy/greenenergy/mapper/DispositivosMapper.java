package com.gabriellibano.greenenergy.greenenergy.mapper;
import com.gabriellibano.greenenergy.greenenergy.dtos.DispositivosRequestCreateDto;
import com.gabriellibano.greenenergy.greenenergy.dtos.DispositivosRequestUpdateDto;
import com.gabriellibano.greenenergy.greenenergy.dtos.DispositivosResponseDto;
import com.gabriellibano.greenenergy.greenenergy.model.Dispositivos;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DispositivosMapper {
    private  final ModelMapper modelMapper;

    public DispositivosResponseDto toDto(Dispositivos contatos) {
        return modelMapper.map(contatos, DispositivosResponseDto.class);
    }

    public Dispositivos toModel(DispositivosRequestCreateDto dto) {
        return modelMapper.map(dto, Dispositivos.class);
    }

    public Dispositivos toModel(Long id, DispositivosRequestUpdateDto dto) {
        Dispositivos result = modelMapper.map(dto, Dispositivos.class);
        result.setId(id);
        return result;
    }
}
