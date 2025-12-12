package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pedido;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private ClienteModel usuario;

    @Column(nullable = false)
    private LocalDateTime fecha_hora;

    @Column(nullable = false)
    private String metodo_pago;

    @Column(nullable = false)
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "id_comuna", nullable = false)
    private ComunaModel comuna;

    @Column(nullable = false)
    private int monto_total;

    @PrePersist
    protected void onCreate() {
        fecha_hora = LocalDateTime.now();
    }
}
