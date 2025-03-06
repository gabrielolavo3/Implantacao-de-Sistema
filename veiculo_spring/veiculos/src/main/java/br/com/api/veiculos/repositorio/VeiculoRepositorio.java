package br.com.api.veiculos.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.api.veiculos.modelo.VeiculoModelo;

@Repository
public interface VeiculoRepositorio extends CrudRepository<VeiculoModelo, Long> {
    
}
