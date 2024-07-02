package br.gov.sp.fatec.domain.request;

import br.gov.sp.fatec.domain.enums.CarroStatus;

public record CarroRequest(String modelo, String marca, Integer ano, CarroStatus status) {}
