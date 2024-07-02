package br.gov.sp.fatec.controller.impl;

import br.gov.sp.fatec.controller.ClienteController;
import br.gov.sp.fatec.domain.entity.Cliente;
import br.gov.sp.fatec.domain.request.ClienteRequest;
import br.gov.sp.fatec.domain.request.ClienteUpdateRequest;
import br.gov.sp.fatec.domain.response.ClienteResponse;
import br.gov.sp.fatec.repository.ClienteRepository;
import br.gov.sp.fatec.service.ClienteService;
import java.util.List;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ClienteControllerImpl implements ClienteController {

    private final ClienteService clienteService;
    private final ClienteRepository clienteRepository;

    @Override
    public ResponseEntity<ClienteResponse> save(@RequestBody ClienteRequest clienteRequest) {
        ClienteResponse cliente = clienteService.save(clienteRequest);
        return ResponseEntity.status(201).body(cliente);
    }
    @Override
    public ResponseEntity<Cliente> findById(Long id) {

        return ResponseEntity.ok(clienteService.findById(id));
    }

    @Override
    public ResponseEntity<List<ClienteResponse>> findAll() {
        return ResponseEntity.ok(clienteService.findAll());
    }

    @Override
    public ResponseEntity<Cliente> updateById(Long id, ClienteUpdateRequest clienteUpdateRequest){
        return ResponseEntity.ok(clienteService.updateById(id, clienteUpdateRequest));
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id){
        clienteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
