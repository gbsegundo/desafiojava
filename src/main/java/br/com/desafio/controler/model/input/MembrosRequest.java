/*
 * Plataforma 2.0
 * Copyright (c) 2023 CRDC - CENTRAL DE REGISTRO DE DIREITOS CREDITORIOS S.A.,
 * Inc. All Rights Reserved.
 *
 * Este software contém informações confidenciais e de propriedade da CRDC S.A.
 * ("Informações Confidenciais"). Você não deve divulgar qualquer tipo de
 * informações confidenciais e deve usá-las apenas, de acordo com os termos do
 * contrato de licença firmado com a CRDC.
 *
 * A CRDC não faz declarações ou garantias sobre a adequação do software,
 * expressa ou implicitamente, incluindo, mas não se limitando, a garantias de
 * comercialização, adequação para um determinado fim ou qualquer tipo de violação.
 *
 * A CENTRAL DE REGISTRO DE DIREITOS CREDITORIOS S.A. NÃO SERÁ RESPONSÁVEL POR
 * QUAISQUER DANOS SOFRIDOS PELO LICENCIADO EM DECORRÊNCIA DO USO, MODIFICAÇÃO OU
 * DISTRIBUIÇÃO DESTE SOFTWARE OU SEUS DERIVADOS.
 */
package br.com.desafio.controler.model.input;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MembrosRequest {
    private String idPessoa;
    private String idProjeto;
}