package br.gov.sp.fatec.repository;

import br.gov.sp.fatec.domain.entity.Aluguel;
import br.gov.sp.fatec.domain.entity.Carro;
import br.gov.sp.fatec.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AluguelRepository extends JpaRepository<Aluguel, Long> {
    List<Aluguel> findByDataInicio(Date dataInicio);

    List<Aluguel> findByDataFim(Date dataFim);

    List<Aluguel> findByCarro(Carro carro);

    List<Aluguel> findByCliente(Cliente cliente);

    Aluguel findById();

}
