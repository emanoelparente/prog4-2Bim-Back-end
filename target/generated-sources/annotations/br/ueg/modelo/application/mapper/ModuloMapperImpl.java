package br.ueg.modelo.application.mapper;

import br.ueg.modelo.application.dto.FuncionalidadeDTO;
import br.ueg.modelo.application.dto.ModuloDTO;
import br.ueg.modelo.application.enums.StatusAtivoInativo;
import br.ueg.modelo.application.model.Funcionalidade;
import br.ueg.modelo.application.model.Modulo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.16.1 (Amazon.com Inc.)"
)
@Component
public class ModuloMapperImpl implements ModuloMapper {

    @Autowired
    private FuncionalidadeMapper funcionalidadeMapper;

    @Override
    public ModuloDTO toDTO(Modulo modulo) {
        if ( modulo == null ) {
            return null;
        }

        ModuloDTO moduloDTO = new ModuloDTO();

        moduloDTO.setIdStatus( moduloStatusId( modulo ) );
        moduloDTO.setDescricaoStatus( moduloStatusDescricao( modulo ) );
        if ( modulo.getId() != null ) {
            moduloDTO.setId( String.valueOf( modulo.getId() ) );
        }
        moduloDTO.setNome( modulo.getNome() );
        moduloDTO.setMnemonico( modulo.getMnemonico() );
        moduloDTO.setFuncionalidades( funcionalidadeSetToFuncionalidadeDTOList( modulo.getFuncionalidades() ) );

        return moduloDTO;
    }

    @Override
    public Modulo toEntity(ModuloDTO moduloDTO) {
        if ( moduloDTO == null ) {
            return null;
        }

        Modulo modulo = new Modulo();

        if ( moduloDTO.getId() != null ) {
            modulo.setId( Long.parseLong( moduloDTO.getId() ) );
        }
        modulo.setNome( moduloDTO.getNome() );
        modulo.setMnemonico( moduloDTO.getMnemonico() );
        modulo.setFuncionalidades( funcionalidadeDTOListToFuncionalidadeSet( moduloDTO.getFuncionalidades() ) );

        modulo.setStatus( StatusAtivoInativo.getById( moduloDTO.getIdStatus() ) );

        return modulo;
    }

    private String moduloStatusId(Modulo modulo) {
        if ( modulo == null ) {
            return null;
        }
        StatusAtivoInativo status = modulo.getStatus();
        if ( status == null ) {
            return null;
        }
        String id = status.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String moduloStatusDescricao(Modulo modulo) {
        if ( modulo == null ) {
            return null;
        }
        StatusAtivoInativo status = modulo.getStatus();
        if ( status == null ) {
            return null;
        }
        String descricao = status.getDescricao();
        if ( descricao == null ) {
            return null;
        }
        return descricao;
    }

    protected List<FuncionalidadeDTO> funcionalidadeSetToFuncionalidadeDTOList(Set<Funcionalidade> set) {
        if ( set == null ) {
            return null;
        }

        List<FuncionalidadeDTO> list = new ArrayList<FuncionalidadeDTO>( set.size() );
        for ( Funcionalidade funcionalidade : set ) {
            list.add( funcionalidadeMapper.toDTO( funcionalidade ) );
        }

        return list;
    }

    protected Set<Funcionalidade> funcionalidadeDTOListToFuncionalidadeSet(List<FuncionalidadeDTO> list) {
        if ( list == null ) {
            return null;
        }

        Set<Funcionalidade> set = new HashSet<Funcionalidade>( Math.max( (int) ( list.size() / .75f ) + 1, 16 ) );
        for ( FuncionalidadeDTO funcionalidadeDTO : list ) {
            set.add( funcionalidadeMapper.toEntity( funcionalidadeDTO ) );
        }

        return set;
    }
}
