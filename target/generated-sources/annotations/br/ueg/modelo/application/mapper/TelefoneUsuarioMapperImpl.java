package br.ueg.modelo.application.mapper;

import br.ueg.modelo.application.dto.TelefoneUsuarioDTO;
import br.ueg.modelo.application.enums.TipoTelefoneUsuario;
import br.ueg.modelo.application.model.TelefoneUsuario;
import br.ueg.modelo.application.model.Usuario;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.16.1 (Amazon.com Inc.)"
)
@Component
public class TelefoneUsuarioMapperImpl implements TelefoneUsuarioMapper {

    @Override
    public TelefoneUsuarioDTO toDTO(TelefoneUsuario telefoneUsuario) {
        if ( telefoneUsuario == null ) {
            return null;
        }

        TelefoneUsuarioDTO telefoneUsuarioDTO = new TelefoneUsuarioDTO();

        telefoneUsuarioDTO.setDescricaoTipo( telefoneUsuarioTipoDescricao( telefoneUsuario ) );
        telefoneUsuarioDTO.setIdTipo( telefoneUsuarioTipoId( telefoneUsuario ) );
        Long id1 = telefoneUsuarioUsuarioId( telefoneUsuario );
        if ( id1 != null ) {
            telefoneUsuarioDTO.setIdUsuario( String.valueOf( id1 ) );
        }
        if ( telefoneUsuario.getId() != null ) {
            telefoneUsuarioDTO.setId( String.valueOf( telefoneUsuario.getId() ) );
        }
        telefoneUsuarioDTO.setNumero( telefoneUsuario.getNumero() );
        if ( telefoneUsuario.getDdd() != null ) {
            telefoneUsuarioDTO.setDdd( String.valueOf( telefoneUsuario.getDdd() ) );
        }

        return telefoneUsuarioDTO;
    }

    @Override
    public TelefoneUsuario toEntity(TelefoneUsuarioDTO telefoneUsuarioDTO) {
        if ( telefoneUsuarioDTO == null ) {
            return null;
        }

        TelefoneUsuario telefoneUsuario = new TelefoneUsuario();

        telefoneUsuario.setUsuario( telefoneUsuarioDTOToUsuario( telefoneUsuarioDTO ) );
        if ( telefoneUsuarioDTO.getId() != null ) {
            telefoneUsuario.setId( Long.parseLong( telefoneUsuarioDTO.getId() ) );
        }
        telefoneUsuario.setNumero( telefoneUsuarioDTO.getNumero() );
        if ( telefoneUsuarioDTO.getDdd() != null ) {
            telefoneUsuario.setDdd( Long.parseLong( telefoneUsuarioDTO.getDdd() ) );
        }

        telefoneUsuario.setTipo( TipoTelefoneUsuario.getById( telefoneUsuarioDTO.getIdTipo() ) );

        return telefoneUsuario;
    }

    private String telefoneUsuarioTipoDescricao(TelefoneUsuario telefoneUsuario) {
        if ( telefoneUsuario == null ) {
            return null;
        }
        TipoTelefoneUsuario tipo = telefoneUsuario.getTipo();
        if ( tipo == null ) {
            return null;
        }
        String descricao = tipo.getDescricao();
        if ( descricao == null ) {
            return null;
        }
        return descricao;
    }

    private Long telefoneUsuarioTipoId(TelefoneUsuario telefoneUsuario) {
        if ( telefoneUsuario == null ) {
            return null;
        }
        TipoTelefoneUsuario tipo = telefoneUsuario.getTipo();
        if ( tipo == null ) {
            return null;
        }
        Long id = tipo.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long telefoneUsuarioUsuarioId(TelefoneUsuario telefoneUsuario) {
        if ( telefoneUsuario == null ) {
            return null;
        }
        Usuario usuario = telefoneUsuario.getUsuario();
        if ( usuario == null ) {
            return null;
        }
        Long id = usuario.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Usuario telefoneUsuarioDTOToUsuario(TelefoneUsuarioDTO telefoneUsuarioDTO) {
        if ( telefoneUsuarioDTO == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        if ( telefoneUsuarioDTO.getIdUsuario() != null ) {
            usuario.setId( Long.parseLong( telefoneUsuarioDTO.getIdUsuario() ) );
        }

        return usuario;
    }
}
