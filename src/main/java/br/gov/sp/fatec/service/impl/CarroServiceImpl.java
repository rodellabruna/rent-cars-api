package br.gov.sp.fatec.service.impl;

import br.gov.sp.fatec.domain.entity.Carro;
import br.gov.sp.fatec.domain.entity.Cliente;
import br.gov.sp.fatec.domain.mapper.CarroMapper;
import br.gov.sp.fatec.domain.request.CarroRequest;
import br.gov.sp.fatec.domain.request.CarroUpdateRequest;
import br.gov.sp.fatec.domain.response.CarroResponse;
import br.gov.sp.fatec.repository.CarroRepository;
import br.gov.sp.fatec.service.CarroService;
import java.util.List;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarroServiceImpl implements CarroService {

    private final CarroRepository carroRepository;
    private final CarroMapper carroMapper;

    @Override
    public CarroResponse save(CarroRequest carroRequest) {
        return null;
    }

    @Override
    public Carro findById(Long id) {
        return carroRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Carro não encontrado"));
    }

    @Override
    public List<CarroResponse> findAll() {

        List<Carro> carros = carroRepository.findAll();
        return carros.stream().map(carroMapper::map).toList();
    }

    @Override
    public void updateById(Long id, CarroUpdateRequest carroUpdateRequest) {}

    @Override
    public void deleteById(Long id) {
        Carro carro = carroRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Carro não encontrado"));
        carroRepository.delete(carro);
    }
}
