package br.ueg.modelo.application.mapper;

import br.ueg.modelo.application.dto.GrupoDTO;
import br.ueg.modelo.application.dto.GrupoFuncionalidadeDTO;
import br.ueg.modelo.application.model.Grupo;
import br.ueg.modelo.application.model.GrupoFuncionalidade;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.16.1 (Amazon.com Inc.)"
)
@Component
public class GrupoMapperImpl implements GrupoMapper {

    @Autowired
    private StatusAtivoInativoMapper statusAtivoInativoMapper;
    @Autowired
    private SimNaoMapper simNaoMapper;
    @Autowired
    private FuncionalidadeMapper funcionalidadeMapper;

    @Override
    public GrupoDTO toDTO(Grupo grupo) {
        if ( grupo == null ) {
            return null;
        }

        GrupoDTO grupoDTO = new GrupoDTO();

        grupoDTO.setId( grupo.getId() );
        grupoDTO.setNome( grupo.getNome() );
        grupoDTO.setDescricao( grupo.getDescricao() );
        if ( grupo.getStatus() != null ) {
            grupoDTO.setStatus( statusAtivoInativoMapper.asBoolean( grupo.getStatus().name() ) );
        }
        grupoDTO.setAdministrador( simNaoMapper.asBoolean( grupo.getAdministrador() ) );
        grupoDTO.setGrupoFuncionalidades( grupoFuncionalidadeSetToGrupoFuncionalidadeDTOSet( grupo.getGrupoFuncionalidades() ) );

        return grupoDTO;
    }

    @Override
    public Grupo toEntity(GrupoDTO grupoDTO) {
        if ( grupoDTO == null ) {
            return null;
        }

        Grupo grupo = new Grupo();

        grupo.setId( grupoDTO.getId() );
        grupo.setNome( grupoDTO.getNome() );
        grupo.setDescricao( grupoDTO.getDescricao() );
        grupo.setStatus( statusAtivoInativoMapper.asStatusSimNao( grupoDTO.isStatus() ) );
        grupo.setAdministrador( simNaoMapper.asStatusSimNao( grupoDTO.isAdministrador() ) );
        grupo.setGrupoFuncionalidades( grupoFuncionalidadeDTOSetToGrupoFuncionalidadeSet( grupoDTO.getGrupoFuncionalidades() ) );

        return grupo;
    }

    protected GrupoFuncionalidadeDTO grupoFuncionalidadeToGrupoFuncionalidadeDTO(GrupoFuncionalidade grupoFuncionalidade) {
        if ( grupoFuncionalidade == null ) {
            return null;
        }

        GrupoFuncionalidadeDTO grupoFuncionalidadeDTO = new GrupoFuncionalidadeDTO();

        if ( grupoFuncionalidade.getId() != null ) {
            grupoFuncionalidadeDTO.setId( String.valueOf( grupoFuncionalidade.getId() ) );
        }
        grupoFuncionalidadeDTO.setFuncionalidade( funcionalidadeMapper.toDTO( grupoFuncionalidade.getFuncionalidade() ) );

        return grupoFuncionalidadeDTO;
    }

    protected Set<GrupoFuncionalidadeDTO> grupoFuncionalidadeSetToGrupoFuncionalidadeDTOSet(Set<GrupoFuncionalidade> set) {
        if ( set == null ) {
            return null;
        }

        Set<GrupoFuncionalidadeDTO> set1 = new HashSet<GrupoFuncionalidadeDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( GrupoFuncionalidade grupoFuncionalidade : set ) {
            set1.add( grupoFuncionalidadeToGrupoFuncionalidadeDTO( grupoFuncionalidade ) );
        }

        return set1;
    }

    protected GrupoFuncionalidade grupoFuncionalidadeDTOToGrupoFuncionalidade(GrupoFuncionalidadeDTO grupoFuncionalidadeDTO) {
        if ( grupoFuncionalidadeDTO == null ) {
            return null;
        }

        GrupoFuncionalidade grupoFuncionalidade = new GrupoFuncionalidade();

        if ( grupoFuncionalidadeDTO.getId() != null ) {
            grupoFuncionalidade.setId( Long.parseLong( grupoFuncionalidadeDTO.getId() ) );
        }
        grupoFuncionalidade.setFuncionalidade( funcionalidadeMapper.toEntity( grupoFuncionalidadeDTO.getFuncionalidade() ) );

        return grupoFuncionalidade;
    }

    protected Set<GrupoFuncionalidade> grupoFuncionalidadeDTOSetToGrupoFuncionalidadeSet(Set<GrupoFuncionalidadeDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<GrupoFuncionalidade> set1 = new HashSet<GrupoFuncionalidade>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( GrupoFuncionalidadeDTO grupoFuncionalidadeDTO : set ) {
            set1.add( grupoFuncionalidadeDTOToGrupoFuncionalidade( grupoFuncionalidadeDTO ) );
        }

        return set1;
    }
}
