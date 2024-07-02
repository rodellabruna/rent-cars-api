package br.gov.sp.fatec.service;

import br.gov.sp.fatec.domain.entity.Cliente;
import br.gov.sp.fatec.domain.request.ClienteRequest;
import br.gov.sp.fatec.domain.request.ClienteUpdateRequest;
import br.gov.sp.fatec.domain.response.ClienteResponse;
import java.util.List;

public interface ClienteService {
    ClienteResponse save(ClienteRequest cliente);

    Cliente findById(Long id);

    List<ClienteResponse> findAll();

    Cliente updateById(Long id, ClienteUpdateRequest clienteUpdateRequest);

    void deleteById(Long id);
}
