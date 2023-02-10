package br.ueg.modelo.application.mapper;

import br.ueg.modelo.application.dto.FuncionalidadeDTO;
import br.ueg.modelo.application.enums.StatusAtivoInativo;
import br.ueg.modelo.application.model.Funcionalidade;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.16.1 (Amazon.com Inc.)"
)
@Component
public class FuncionalidadeMapperImpl implements FuncionalidadeMapper {

    @Override
    public FuncionalidadeDTO toDTO(Funcionalidade funcionalidade) {
        if ( funcionalidade == null ) {
            return null;
        }

        FuncionalidadeDTO funcionalidadeDTO = new FuncionalidadeDTO();

        funcionalidadeDTO.setIdStatus( funcionalidadeStatusId( funcionalidade ) );
        funcionalidadeDTO.setDescricaoStatus( funcionalidadeStatusDescricao( funcionalidade ) );
        if ( funcionalidade.getId() != null ) {
            funcionalidadeDTO.setId( String.valueOf( funcionalidade.getId() ) );
        }
        funcionalidadeDTO.setNome( funcionalidade.getNome() );
        funcionalidadeDTO.setMnemonico( funcionalidade.getMnemonico() );

        return funcionalidadeDTO;
    }

    @Override
    public Funcionalidade toEntity(FuncionalidadeDTO funcionalidadeDTO) {
        if ( funcionalidadeDTO == null ) {
            return null;
        }

        Funcionalidade funcionalidade = new Funcionalidade();

        if ( funcionalidadeDTO.getId() != null ) {
            funcionalidade.setId( Long.parseLong( funcionalidadeDTO.getId() ) );
        }
        funcionalidade.setNome( funcionalidadeDTO.getNome() );
        funcionalidade.setMnemonico( funcionalidadeDTO.getMnemonico() );

        funcionalidade.setStatus( StatusAtivoInativo.getById( funcionalidadeDTO.getIdStatus() ) );

        return funcionalidade;
    }

    private String funcionalidadeStatusId(Funcionalidade funcionalidade) {
        if ( funcionalidade == null ) {
            return null;
        }
        StatusAtivoInativo status = funcionalidade.getStatus();
        if ( status == null ) {
            return null;
        }
        String id = status.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String funcionalidadeStatusDescricao(Funcionalidade funcionalidade) {
        if ( funcionalidade == null ) {
            return null;
        }
        StatusAtivoInativo status = funcionalidade.getStatus();
        if ( status == null ) {
            return null;
        }
        String descricao = status.getDescricao();
        if ( descricao == null ) {
            return null;
        }
        return descricao;
    }
}
