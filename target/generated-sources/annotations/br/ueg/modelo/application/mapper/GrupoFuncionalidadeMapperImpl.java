package br.ueg.modelo.application.mapper;

import br.ueg.modelo.application.dto.GrupoFuncionalidadeDTO;
import br.ueg.modelo.application.model.Grupo;
import br.ueg.modelo.application.model.GrupoFuncionalidade;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.16.1 (Amazon.com Inc.)"
)
@Component
public class GrupoFuncionalidadeMapperImpl implements GrupoFuncionalidadeMapper {

    @Autowired
    private FuncionalidadeMapper funcionalidadeMapper;

    @Override
    public GrupoFuncionalidadeDTO toDTO(GrupoFuncionalidade grupoFuncionalidade) {
        if ( grupoFuncionalidade == null ) {
            return null;
        }

        GrupoFuncionalidadeDTO grupoFuncionalidadeDTO = new GrupoFuncionalidadeDTO();

        Long id = grupoFuncionalidadeGrupoId( grupoFuncionalidade );
        if ( id != null ) {
            grupoFuncionalidadeDTO.setIdGrupo( String.valueOf( id ) );
        }
        if ( grupoFuncionalidade.getId() != null ) {
            grupoFuncionalidadeDTO.setId( String.valueOf( grupoFuncionalidade.getId() ) );
        }
        grupoFuncionalidadeDTO.setFuncionalidade( funcionalidadeMapper.toDTO( grupoFuncionalidade.getFuncionalidade() ) );

        return grupoFuncionalidadeDTO;
    }

    @Override
    public GrupoFuncionalidade toEntity(GrupoFuncionalidadeDTO grupoFuncionalidadeDTO) {
        if ( grupoFuncionalidadeDTO == null ) {
            return null;
        }

        GrupoFuncionalidade grupoFuncionalidade = new GrupoFuncionalidade();

        grupoFuncionalidade.setGrupo( grupoFuncionalidadeDTOToGrupo( grupoFuncionalidadeDTO ) );
        if ( grupoFuncionalidadeDTO.getId() != null ) {
            grupoFuncionalidade.setId( Long.parseLong( grupoFuncionalidadeDTO.getId() ) );
        }
        grupoFuncionalidade.setFuncionalidade( funcionalidadeMapper.toEntity( grupoFuncionalidadeDTO.getFuncionalidade() ) );

        return grupoFuncionalidade;
    }

    private Long grupoFuncionalidadeGrupoId(GrupoFuncionalidade grupoFuncionalidade) {
        if ( grupoFuncionalidade == null ) {
            return null;
        }
        Grupo grupo = grupoFuncionalidade.getGrupo();
        if ( grupo == null ) {
            return null;
        }
        Long id = grupo.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Grupo grupoFuncionalidadeDTOToGrupo(GrupoFuncionalidadeDTO grupoFuncionalidadeDTO) {
        if ( grupoFuncionalidadeDTO == null ) {
            return null;
        }

        Grupo grupo = new Grupo();

        if ( grupoFuncionalidadeDTO.getIdGrupo() != null ) {
            grupo.setId( Long.parseLong( grupoFuncionalidadeDTO.getIdGrupo() ) );
        }

        return grupo;
    }
}
