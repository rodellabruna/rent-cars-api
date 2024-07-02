package br.gov.sp.fatec.domain.mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

import br.gov.sp.fatec.domain.entity.Aluguel;
import br.gov.sp.fatec.domain.request.AluguelRequest;
import br.gov.sp.fatec.domain.response.AluguelResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = SPRING)
public interface AluguelMapper {
    @Mapping(target = "carro.id", source = "carroId")
    @Mapping(target = "cliente.id", source = "clienteId")
    Aluguel map(AluguelRequest aluguelRequest);

    AluguelResponse map(Aluguel aluguel);
}
