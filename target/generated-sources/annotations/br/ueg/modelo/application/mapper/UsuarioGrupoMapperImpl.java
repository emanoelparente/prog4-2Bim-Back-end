package br.ueg.modelo.application.mapper;

import br.ueg.modelo.application.dto.UsuarioGrupoDTO;
import br.ueg.modelo.application.model.Grupo;
import br.ueg.modelo.application.model.Usuario;
import br.ueg.modelo.application.model.UsuarioGrupo;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.16.1 (Amazon.com Inc.)"
)
@Component
public class UsuarioGrupoMapperImpl implements UsuarioGrupoMapper {

    @Override
    public UsuarioGrupoDTO toDTO(UsuarioGrupo usuarioGrupo) {
        if ( usuarioGrupo == null ) {
            return null;
        }

        UsuarioGrupoDTO usuarioGrupoDTO = new UsuarioGrupoDTO();

        usuarioGrupoDTO.setNomeGrupo( usuarioGrupoGrupoNome( usuarioGrupo ) );
        Long id = usuarioGrupoUsuarioId( usuarioGrupo );
        if ( id != null ) {
            usuarioGrupoDTO.setIdUsuario( String.valueOf( id ) );
        }
        Long id1 = usuarioGrupoGrupoId( usuarioGrupo );
        if ( id1 != null ) {
            usuarioGrupoDTO.setIdGrupo( String.valueOf( id1 ) );
        }
        if ( usuarioGrupo.getId() != null ) {
            usuarioGrupoDTO.setId( String.valueOf( usuarioGrupo.getId() ) );
        }

        return usuarioGrupoDTO;
    }

    @Override
    public UsuarioGrupo toEntity(UsuarioGrupoDTO usuarioGrupoDTO) {
        if ( usuarioGrupoDTO == null ) {
            return null;
        }

        UsuarioGrupo usuarioGrupo = new UsuarioGrupo();

        usuarioGrupo.setUsuario( usuarioGrupoDTOToUsuario( usuarioGrupoDTO ) );
        usuarioGrupo.setGrupo( usuarioGrupoDTOToGrupo( usuarioGrupoDTO ) );
        if ( usuarioGrupoDTO.getId() != null ) {
            usuarioGrupo.setId( Long.parseLong( usuarioGrupoDTO.getId() ) );
        }

        return usuarioGrupo;
    }

    private String usuarioGrupoGrupoNome(UsuarioGrupo usuarioGrupo) {
        if ( usuarioGrupo == null ) {
            return null;
        }
        Grupo grupo = usuarioGrupo.getGrupo();
        if ( grupo == null ) {
            return null;
        }
        String nome = grupo.getNome();
        if ( nome == null ) {
            return null;
        }
        return nome;
    }

    private Long usuarioGrupoUsuarioId(UsuarioGrupo usuarioGrupo) {
        if ( usuarioGrupo == null ) {
            return null;
        }
        Usuario usuario = usuarioGrupo.getUsuario();
        if ( usuario == null ) {
            return null;
        }
        Long id = usuario.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long usuarioGrupoGrupoId(UsuarioGrupo usuarioGrupo) {
        if ( usuarioGrupo == null ) {
            return null;
        }
        Grupo grupo = usuarioGrupo.getGrupo();
        if ( grupo == null ) {
            return null;
        }
        Long id = grupo.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Usuario usuarioGrupoDTOToUsuario(UsuarioGrupoDTO usuarioGrupoDTO) {
        if ( usuarioGrupoDTO == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        if ( usuarioGrupoDTO.getIdUsuario() != null ) {
            usuario.setId( Long.parseLong( usuarioGrupoDTO.getIdUsuario() ) );
        }

        return usuario;
    }

    protected Grupo usuarioGrupoDTOToGrupo(UsuarioGrupoDTO usuarioGrupoDTO) {
        if ( usuarioGrupoDTO == null ) {
            return null;
        }

        Grupo grupo = new Grupo();

        if ( usuarioGrupoDTO.getIdGrupo() != null ) {
            grupo.setId( Long.parseLong( usuarioGrupoDTO.getIdGrupo() ) );
        }

        return grupo;
    }
}
