package com.example.demo.Config;

import com.example.demo.Model.*;
import com.example.demo.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    private AudifonoRepository audifonoRepository;

    @Autowired
    private MouseRepository mouseRepository;

    @Autowired
    private TecladoRepository tecladoRepository;

    @Autowired
    private NotebookRepository notebookRepository;

    @Override
    public void run(String... args) throws Exception {
        // Solo ejecutar el seeder si la base de datos está vacía
        if (adminRepository.count() == 0) {
            System.out.println("🌱 Iniciando seeder de base de datos...");
            seedAdmins();
            seedClientes();
            seedRegiones();
            seedAudifonos();
            seedMouses();
            seedTeclados();
            seedNotebooks();
            System.out.println("✅ Seeder completado exitosamente!");
        } else {
            System.out.println("ℹ️ La base de datos ya contiene datos. Seeder omitido.");
        }
    }

    private void seedAdmins() {
        AdminModel admin1 = new AdminModel();
        admin1.setNombre("Administrador Principal");
        admin1.setRol("admin");
        admin1.setCorreo("admin@levelup.com");
        admin1.setContraseña("admin123");
        adminRepository.save(admin1);

        AdminModel admin2 = new AdminModel();
        admin2.setNombre("Super Admin");
        admin2.setRol("superadmin");
        admin2.setCorreo("superadmin@levelup.com");
        admin2.setContraseña("super123");
        adminRepository.save(admin2);

        System.out.println("✅ Admins creados: " + adminRepository.count());
    }

    private void seedClientes() {
        ClienteModel cliente1 = new ClienteModel();
        cliente1.setNombre("Juan Pérez");
        cliente1.setRol("cliente");
        cliente1.setCorreo("juan@gmail.com");
        cliente1.setContraseña("juan123");
        clienteRepository.save(cliente1);

        ClienteModel cliente2 = new ClienteModel();
        cliente2.setNombre("María González");
        cliente2.setRol("cliente");
        cliente2.setCorreo("maria@gmail.com");
        cliente2.setContraseña("maria123");
        clienteRepository.save(cliente2);

        ClienteModel cliente3 = new ClienteModel();
        cliente3.setNombre("Carlos Rodríguez");
        cliente3.setRol("cliente");
        cliente3.setCorreo("carlos@gmail.com");
        cliente3.setContraseña("carlos123");
        clienteRepository.save(cliente3);

        System.out.println("✅ Clientes creados: " + clienteRepository.count());
    }

    private void seedRegiones() {
        String[] regiones = {
            "Arica y Parinacota", "Tarapacá", "Antofagasta", "Atacama",
            "Coquimbo", "Valparaíso", "Metropolitana", "O'Higgins",
            "Maule", "Ñuble", "Biobío", "Araucanía",
            "Los Ríos", "Los Lagos", "Aysén", "Magallanes"
        };

        for (String nombreRegion : regiones) {
            Region region = new Region();
            region.setNombre(nombreRegion);
            regionRepository.save(region);
        }

        System.out.println("✅ Regiones creadas: " + regionRepository.count());
    }

    private void seedAudifonos() {
        AudifonoModel audifono1 = new AudifonoModel();
        audifono1.setNombre("Razer Kraken Pro V2");
        audifono1.setCategoria("Audífonos");
        audifono1.setMarca("Razer");
        audifono1.setPrecio(89990);
        audifono1.setStock(25);
        audifono1.setInalambrico("No");
        audifono1.setColor("Negro");
        audifono1.setBotonesCant(3);
        audifono1.setDescripcion("Audífonos gaming profesionales con sonido envolvente 7.1");
        audifono1.setUrlImagen("https://example.com/razer-kraken.jpg");
        audifonoRepository.save(audifono1);

        AudifonoModel audifono2 = new AudifonoModel();
        audifono2.setNombre("Logitech G733");
        audifono2.setCategoria("Audífonos");
        audifono2.setMarca("Logitech");
        audifono2.setPrecio(124990);
        audifono2.setStock(15);
        audifono2.setInalambrico("Sí");
        audifono2.setColor("Blanco");
        audifono2.setBotonesCant(4);
        audifono2.setDescripcion("Audífonos inalámbricos RGB ligeros y cómodos");
        audifono2.setUrlImagen("https://example.com/logitech-g733.jpg");
        audifonoRepository.save(audifono2);

        System.out.println("✅ Audífonos creados: " + audifonoRepository.count());
    }

    private void seedMouses() {
        MouseModel mouse1 = new MouseModel();
        mouse1.setNombre("Logitech G502 HERO");
        mouse1.setCategoria("Mouse");
        mouse1.setMarca("Logitech");
        mouse1.setPrecio(59990);
        mouse1.setStock(30);
        mouse1.setInalambrico("No");
        mouse1.setColor("Negro");
        mouse1.setBotonesCant(11);
        mouse1.setDpiMin(100);
        mouse1.setDpiMax(25600);
        mouse1.setDescripcion("Mouse gaming de alta precisión con sensor HERO");
        mouse1.setUrlImagen("https://example.com/g502.jpg");
        mouseRepository.save(mouse1);

        MouseModel mouse2 = new MouseModel();
        mouse2.setNombre("Razer DeathAdder V3");
        mouse2.setCategoria("Mouse");
        mouse2.setMarca("Razer");
        mouse2.setPrecio(79990);
        mouse2.setStock(20);
        mouse2.setInalambrico("Sí");
        mouse2.setColor("Negro");
        mouse2.setBotonesCant(8);
        mouse2.setDpiMin(100);
        mouse2.setDpiMax(30000);
        mouse2.setDescripcion("Mouse inalámbrico profesional ultra ligero");
        mouse2.setUrlImagen("https://example.com/deathadder.jpg");
        mouseRepository.save(mouse2);

        System.out.println("✅ Mouses creados: " + mouseRepository.count());
    }

    private void seedTeclados() {
        TecladoModel teclado1 = new TecladoModel();
        teclado1.setNombre("Corsair K70 RGB");
        teclado1.setCategoria("Teclado");
        teclado1.setMarca("Corsair");
        teclado1.setPrecio(149990);
        teclado1.setStock(18);
        teclado1.setColor("Negro");
        teclado1.setInalambrico("No");
        teclado1.setDimension("Full Size");
        teclado1.setTipo("Mecánico");
        teclado1.setSwitches("Cherry MX Red");
        teclado1.setDescripcion("Teclado mecánico gaming con iluminación RGB por tecla");
        teclado1.setUrlImagen("https://example.com/k70.jpg");
        tecladoRepository.save(teclado1);

        TecladoModel teclado2 = new TecladoModel();
        teclado2.setNombre("Razer BlackWidow V4");
        teclado2.setCategoria("Teclado");
        teclado2.setMarca("Razer");
        teclado2.setPrecio(179990);
        teclado2.setStock(12);
        teclado2.setColor("Negro");
        teclado2.setInalambrico("Sí");
        teclado2.setDimension("TKL");
        teclado2.setTipo("Mecánico");
        teclado2.setSwitches("Razer Green");
        teclado2.setDescripcion("Teclado mecánico inalámbrico compacto");
        teclado2.setUrlImagen("https://example.com/blackwidow.jpg");
        tecladoRepository.save(teclado2);

        System.out.println("✅ Teclados creados: " + tecladoRepository.count());
    }

    private void seedNotebooks() {
        NotebookModel notebook1 = new NotebookModel();
        notebook1.setNombre("ASUS ROG Strix G15");
        notebook1.setCategoria("Notebook");
        notebook1.setMarca("ASUS");
        notebook1.setPrecio(1299990);
        notebook1.setStock(8);
        notebook1.setColor("Negro");
        notebook1.setProcesador("AMD Ryzen 7 6800H");
        notebook1.setRam("16GB DDR5");
        notebook1.setMemoria("512GB SSD");
        notebook1.setTarjetaVideo("NVIDIA RTX 3060 6GB");
        notebook1.setDescripcion("Notebook gaming potente con pantalla 144Hz");
        notebook1.setUrlImagen("https://example.com/rog-strix.jpg");
        notebookRepository.save(notebook1);

        NotebookModel notebook2 = new NotebookModel();
        notebook2.setNombre("Lenovo Legion 5 Pro");
        notebook2.setCategoria("Notebook");
        notebook2.setMarca("Lenovo");
        notebook2.setPrecio(1499990);
        notebook2.setStock(5);
        notebook2.setColor("Gris");
        notebook2.setProcesador("Intel Core i7-12700H");
        notebook2.setRam("32GB DDR5");
        notebook2.setMemoria("1TB SSD");
        notebook2.setTarjetaVideo("NVIDIA RTX 3070 Ti 8GB");
        notebook2.setDescripcion("Notebook premium para gaming y creación de contenido");
        notebook2.setUrlImagen("https://example.com/legion5.jpg");
        notebookRepository.save(notebook2);

        System.out.println("✅ Notebooks creados: " + notebookRepository.count());
    }
}
