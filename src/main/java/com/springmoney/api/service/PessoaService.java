package com.springmoney.api.service;

import com.springmoney.api.model.Pessoa;
import com.springmoney.api.repository.PessoaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa atualizar(Integer codigo, Pessoa pessoa) {
        Pessoa pessoaSalva = buscarPessoaPeloCodigo(codigo);
        BeanUtils.copyProperties(pessoa, pessoaSalva, "codigo");
        return pessoaRepository.save(pessoaSalva);
    }

    public void atualizarPropriedadeAtivo(Integer codigo, Boolean ativo) {
        Pessoa pessoaSalva = buscarPessoaPeloCodigo(codigo);
        pessoaSalva.setAtivo(ativo);
        pessoaRepository.save(pessoaSalva);
    }

    private Pessoa buscarPessoaPeloCodigo(Integer codigo) {
        Pessoa pessoaSalva = pessoaRepository.findById(codigo).orElse(null);
        if(pessoaSalva == null){
            throw new EmptyResultDataAccessException(1);
        }
        return pessoaSalva;
    }
}
