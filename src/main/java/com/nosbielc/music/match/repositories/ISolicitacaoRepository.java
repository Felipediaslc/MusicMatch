package com.nosbielc.music.match.repositories;

import com.nosbielc.music.match.entities.Solicitacao;
import com.nosbielc.music.match.enums.SolicitacaoStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ISolicitacaoRepository extends JpaRepository<Solicitacao, Long> {

    Optional<List<Solicitacao>> findAllBySolicitacaoStatusOrderByIdAsc(SolicitacaoStatus solicitacaoStatus);

}
