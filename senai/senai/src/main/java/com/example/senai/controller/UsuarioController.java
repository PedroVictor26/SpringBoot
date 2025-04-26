package com.example.senai.controller;

import com.example.senai.model.Usuario;
import com.example.senai.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    public List<Usuario> ListarTodos() {
        return usuarioService.ListarTodos();
    }

    public ResponseEntity<Map<String, Object>> salvar(@Valid @RequestBody Usuario usuario) {
        usuarioService.salvar(usuario);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "Usuario cadastrado com sucesso"));
    }

    public ResponseEntity<Map<String, Object>> atualizar(@Valid @RequestBody Usuario usuario) {
        usuarioService.atualizar(usuario);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Usuario atualizado com sucesso"));
    }

    public ResponseEntity<Map<String, Object>> excluir(@Valid @RequestBody Long id) {
        usuarioService.excluir(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Usuario excluido com sucesso"));
    }


}
