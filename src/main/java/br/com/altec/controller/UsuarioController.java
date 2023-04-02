package br.com.altec.controller;

import br.com.altec.entities.Usuario;
import br.com.altec.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository userRepository;

    @GetMapping
    public List<Usuario> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public Usuario getUserById(@PathVariable Long id) {
        return userRepository.findById(id).get();
    }

    @PostMapping
    public Usuario createUser(@RequestBody Usuario usuario) {
        return userRepository.save(usuario);
    }

    @PutMapping("/{id}")
    public Usuario updateUser(@PathVariable Long id, @RequestBody Usuario usuario) {
        Usuario existingUser = userRepository.findById(id).get();
        existingUser.setName(usuario.getName());
        existingUser.setEmail(usuario.getEmail());
        return userRepository.save(existingUser);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        try {
            userRepository.findById(id).get();
            userRepository.deleteById(id);
            return "User deleted successfully";
        } catch (Exception e) {
            return "User not found";
        }
    }
}
