package br.gov.sp.fatec.service.impl;

import br.gov.sp.fatec.domain.entity.Carro;
import br.gov.sp.fatec.domain.entity.Cliente;
import br.gov.sp.fatec.domain.mapper.ClienteMapper;
import br.gov.sp.fatec.domain.request.ClienteRequest;
import br.gov.sp.fatec.domain.request.ClienteUpdateRequest;
import br.gov.sp.fatec.domain.response.ClienteResponse;
import br.gov.sp.fatec.repository.ClienteRepository;
import br.gov.sp.fatec.service.ClienteService;
import java.util.List;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    @Override
    public ClienteResponse save(ClienteRequest clienteRequest) {
        Cliente cliente = clienteMapper.map(clienteRequest);
        Cliente savedCliente = clienteRepository.save(cliente);
        return clienteMapper.map(savedCliente);
    }

    @Override
    public Cliente findById(Long id) {
        return clienteRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
    }

    @Override
    public List<ClienteResponse> findAll() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream().map(clienteMapper::map).toList();
    }

    @Override
    public Cliente updateById(Long id, ClienteUpdateRequest clienteUpdateRequest) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente not found"));
        cliente.setNome(clienteUpdateRequest.nome());
        cliente.setTelefone(clienteUpdateRequest.telefone());
        cliente.setCpf(clienteUpdateRequest.cpf());
        return clienteRepository.save(cliente);
    }

    @Override
    public void deleteById(Long id) {
        Cliente cliente = clienteRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
        clienteRepository.delete(cliente);
    }
}
