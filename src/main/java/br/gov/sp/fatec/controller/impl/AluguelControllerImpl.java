package br.gov.sp.fatec.controller.impl;

import br.gov.sp.fatec.controller.AluguelController;
import br.gov.sp.fatec.domain.entity.Aluguel;
import br.gov.sp.fatec.domain.request.AluguelRequest;
import br.gov.sp.fatec.domain.request.AluguelUpdateRequest;
import br.gov.sp.fatec.domain.response.AluguelResponse;
import br.gov.sp.fatec.domain.response.ClienteResponse;
import br.gov.sp.fatec.service.AluguelService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AluguelControllerImpl implements AluguelController {

    private final AluguelService aluguelService;

    @Override
    public ResponseEntity<AluguelResponse> save(@RequestBody AluguelRequest aluguelRequest) {
        AluguelResponse aluguel = aluguelService.save(aluguelRequest);
        return ResponseEntity.status(201).body(aluguel);
    }

    @Override
    public ResponseEntity<Aluguel> findById(Long id) {
        return ResponseEntity.ok(aluguelService.findById(id));
    }

    @Override
    public ResponseEntity<List<AluguelResponse>> findAll() {
        return ResponseEntity.ok(aluguelService.findAll());
    }

    @Override
    public ResponseEntity<Aluguel> updateById(@PathVariable Long id, @RequestBody AluguelUpdateRequest aluguelUpdateRequest) {
        Aluguel aluguel = aluguelService.updateById(id, aluguelUpdateRequest);
        return ResponseEntity.ok(aluguel);
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        aluguelService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
