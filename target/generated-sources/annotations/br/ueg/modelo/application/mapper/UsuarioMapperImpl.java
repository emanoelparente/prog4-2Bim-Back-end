package br.ueg.modelo.application.mapper;

import br.ueg.modelo.application.dto.TelefoneUsuarioDTO;
import br.ueg.modelo.application.dto.UsuarioDTO;
import br.ueg.modelo.application.dto.UsuarioGrupoDTO;
import br.ueg.modelo.application.model.TelefoneUsuario;
import br.ueg.modelo.application.model.Usuario;
import br.ueg.modelo.application.model.UsuarioGrupo;
import java.math.BigDecimal;
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
public class UsuarioMapperImpl implements UsuarioMapper {

    @Autowired
    private StatusAtivoInativoMapper statusAtivoInativoMapper;
    @Autowired
    private SimNaoMapper simNaoMapper;
    @Autowired
    private UsuarioGrupoMapper usuarioGrupoMapper;
    @Autowired
    private TelefoneUsuarioMapper telefoneUsuarioMapper;

    @Override
    public UsuarioDTO toDTO(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        UsuarioDTO usuarioDTO = new UsuarioDTO();

        if ( usuario.getId() != null ) {
            usuarioDTO.setId( String.valueOf( usuario.getId() ) );
        }
        usuarioDTO.setDataAtualizado( usuario.getDataAtualizado() );
        usuarioDTO.setDataCadastrado( usuario.getDataCadastrado() );
        usuarioDTO.setEmail( usuario.getEmail() );
        usuarioDTO.setLogin( usuario.getLogin() );
        usuarioDTO.setNome( usuario.getNome() );
        usuarioDTO.setCpf( usuario.getCpf() );
        if ( usuario.getStatus() != null ) {
            usuarioDTO.setStatus( statusAtivoInativoMapper.asBoolean( usuario.getStatus().name() ) );
        }
        if ( usuario.getQuantidadeTentativaAcesso() != null ) {
            usuarioDTO.setQuantidadeTentativaAcesso( new BigDecimal( usuario.getQuantidadeTentativaAcesso() ) );
        }
        usuarioDTO.setUltimoAcesso( usuario.getUltimoAcesso() );
        usuarioDTO.setDataAcessoExpirado( usuario.getDataAcessoExpirado() );
        usuarioDTO.setAcessoBloqueado( simNaoMapper.asBoolean( usuario.getAcessoBloqueado() ) );
        usuarioDTO.setAcessoExpirado( simNaoMapper.asBoolean( usuario.getAcessoExpirado() ) );
        usuarioDTO.setQuantidadeAcesso( usuario.getQuantidadeAcesso() );
        usuarioDTO.setGrupos( usuarioGrupoSetToUsuarioGrupoDTOList( usuario.getGrupos() ) );
        usuarioDTO.setTelefones( telefoneUsuarioSetToTelefoneUsuarioDTOList( usuario.getTelefones() ) );

        return usuarioDTO;
    }

    @Override
    public Usuario toEntity(UsuarioDTO usuarioDTO) {
        if ( usuarioDTO == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        if ( usuarioDTO.getId() != null ) {
            usuario.setId( Long.parseLong( usuarioDTO.getId() ) );
        }
        usuario.setDataAtualizado( usuarioDTO.getDataAtualizado() );
        usuario.setDataCadastrado( usuarioDTO.getDataCadastrado() );
        usuario.setEmail( usuarioDTO.getEmail() );
        usuario.setLogin( usuarioDTO.getLogin() );
        usuario.setNome( usuarioDTO.getNome() );
        usuario.setCpf( usuarioDTO.getCpf() );
        usuario.setStatus( statusAtivoInativoMapper.asStatusSimNao( usuarioDTO.isStatus() ) );
        usuario.setAcessoBloqueado( simNaoMapper.asStatusSimNao( usuarioDTO.isAcessoBloqueado() ) );
        if ( usuarioDTO.getQuantidadeTentativaAcesso() != null ) {
            usuario.setQuantidadeTentativaAcesso( usuarioDTO.getQuantidadeTentativaAcesso().toString() );
        }
        usuario.setUltimoAcesso( usuarioDTO.getUltimoAcesso() );
        usuario.setDataAcessoExpirado( usuarioDTO.getDataAcessoExpirado() );
        usuario.setAcessoExpirado( simNaoMapper.asStatusSimNao( usuarioDTO.isAcessoExpirado() ) );
        usuario.setQuantidadeAcesso( usuarioDTO.getQuantidadeAcesso() );
        usuario.setGrupos( usuarioGrupoDTOListToUsuarioGrupoSet( usuarioDTO.getGrupos() ) );
        usuario.setTelefones( telefoneUsuarioDTOListToTelefoneUsuarioSet( usuarioDTO.getTelefones() ) );

        return usuario;
    }

    protected List<UsuarioGrupoDTO> usuarioGrupoSetToUsuarioGrupoDTOList(Set<UsuarioGrupo> set) {
        if ( set == null ) {
            return null;
        }

        List<UsuarioGrupoDTO> list = new ArrayList<UsuarioGrupoDTO>( set.size() );
        for ( UsuarioGrupo usuarioGrupo : set ) {
            list.add( usuarioGrupoMapper.toDTO( usuarioGrupo ) );
        }

        return list;
    }

    protected List<TelefoneUsuarioDTO> telefoneUsuarioSetToTelefoneUsuarioDTOList(Set<TelefoneUsuario> set) {
        if ( set == null ) {
            return null;
        }

        List<TelefoneUsuarioDTO> list = new ArrayList<TelefoneUsuarioDTO>( set.size() );
        for ( TelefoneUsuario telefoneUsuario : set ) {
            list.add( telefoneUsuarioMapper.toDTO( telefoneUsuario ) );
        }

        return list;
    }

    protected Set<UsuarioGrupo> usuarioGrupoDTOListToUsuarioGrupoSet(List<UsuarioGrupoDTO> list) {
        if ( list == null ) {
            return null;
        }

        Set<UsuarioGrupo> set = new HashSet<UsuarioGrupo>( Math.max( (int) ( list.size() / .75f ) + 1, 16 ) );
        for ( UsuarioGrupoDTO usuarioGrupoDTO : list ) {
            set.add( usuarioGrupoMapper.toEntity( usuarioGrupoDTO ) );
        }

        return set;
    }

    protected Set<TelefoneUsuario> telefoneUsuarioDTOListToTelefoneUsuarioSet(List<TelefoneUsuarioDTO> list) {
        if ( list == null ) {
            return null;
        }

        Set<TelefoneUsuario> set = new HashSet<TelefoneUsuario>( Math.max( (int) ( list.size() / .75f ) + 1, 16 ) );
        for ( TelefoneUsuarioDTO telefoneUsuarioDTO : list ) {
            set.add( telefoneUsuarioMapper.toEntity( telefoneUsuarioDTO ) );
        }

        return set;
    }
}
