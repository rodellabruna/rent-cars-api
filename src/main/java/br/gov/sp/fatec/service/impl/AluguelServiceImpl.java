package br.gov.sp.fatec.service.impl;

import br.gov.sp.fatec.domain.entity.Aluguel;
import br.gov.sp.fatec.domain.entity.Carro;
import br.gov.sp.fatec.domain.entity.Cliente;
import br.gov.sp.fatec.domain.mapper.AluguelMapper;
import br.gov.sp.fatec.domain.request.AluguelRequest;
import br.gov.sp.fatec.domain.request.AluguelUpdateRequest;
import br.gov.sp.fatec.domain.response.AluguelResponse;
import br.gov.sp.fatec.repository.AluguelRepository;
import br.gov.sp.fatec.repository.CarroRepository;
import br.gov.sp.fatec.repository.ClienteRepository;
import br.gov.sp.fatec.service.AluguelService;
import java.util.List;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AluguelServiceImpl implements AluguelService {

    @Autowired
    private final AluguelRepository aluguelRepository;

    @Autowired
    private final AluguelMapper aluguelMapper;

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public AluguelResponse save(AluguelRequest aluguelRequest) {
        Aluguel aluguel = aluguelMapper.map(aluguelRequest);
        Aluguel savedAluguel = aluguelRepository.save(aluguel);
        return aluguelMapper.map(savedAluguel);
    }

    @Override
    public Aluguel findById(Long id) {
        return aluguelRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Aluguel não encontrado"));
    }

    @Override
    public List<AluguelResponse> findAll() {
        List<Aluguel> alugueis = aluguelRepository.findAll();
        return alugueis.stream().map(aluguelMapper::map).toList();
    }

    @Override
    public Aluguel updateById(Long id, AluguelUpdateRequest aluguelUpdateRequest) {
        Aluguel aluguel = aluguelRepository.findById(id).orElseThrow(() -> new RuntimeException("Aluguel not found"));
        aluguel.setDataInicio(aluguelUpdateRequest.dataInicio());
        aluguel.setDataFim(aluguelUpdateRequest.dataFim());
        aluguel.setValor(aluguelUpdateRequest.valor());
        Carro carro = carroRepository.findById(aluguelUpdateRequest.carroId()).orElseThrow(() -> new RuntimeException("Carro not found"));
        Cliente cliente = clienteRepository.findById(aluguelUpdateRequest.clienteId()).orElseThrow(() -> new RuntimeException("Cliente not found"));
        aluguel.setCarro(carro);
        aluguel.setCliente(cliente);
        aluguel.setStatus(aluguelUpdateRequest.status());
        return aluguelRepository.save(aluguel);
    }

    @Override
    public void deleteById(Long id) {
        Aluguel aluguel = aluguelRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Aluguel não encontrado"));
        aluguelRepository.delete(aluguel);
    }
}
