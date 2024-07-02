package br.gov.sp.fatec.domain.request;

import br.gov.sp.fatec.domain.enums.CarroStatus;

public record CarroUpdateRequest(String modelo, String marca, Integer ano, CarroStatus status) {}
