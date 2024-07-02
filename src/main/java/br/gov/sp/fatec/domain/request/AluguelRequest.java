package br.gov.sp.fatec.domain.request;

import br.gov.sp.fatec.domain.entity.Carro;
import br.gov.sp.fatec.domain.entity.Cliente;

import java.util.Date;

public record AluguelRequest(Date dataInicio, Date dataFim, double valor, Carro carro, Cliente cliente) {}
