package nsg.portafolio.controller;

import nsg.portafolio.entity.Product;
import nsg.portafolio.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/create")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> addProduct(@RequestBody Product product) {
        System.out.println("Crear producto");
        this.productRepository.save(product);
        return new ResponseEntity<>("Producto Creado con éxito", HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> updateProduct(@PathVariable int id,
            @RequestBody Product product) {
        Product productFound = this.productRepository.findById(id).orElseThrow();
        productFound.setName(product.getName());
        productFound.setPrice(product.getPrice());
        this.productRepository.save(productFound);
        return new ResponseEntity<>("Producto Actualizado con éxito", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        this.productRepository.deleteById(id);
        return new ResponseEntity<>("Producto Eliminado con éxito", HttpStatus.OK);
    }

}
