package com.example.demo.Config;

import com.example.demo.Model.*;
import com.example.demo.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    // Repositorios inyectados (sin cambios)
    @Autowired private AdminRepository adminRepository;
    @Autowired private ClienteRepository clienteRepository;
    @Autowired private RegionRepository regionRepository;
    @Autowired private AudifonoRepository audifonoRepository;
    @Autowired private MouseRepository mouseRepository;
    @Autowired private TecladoRepository tecladoRepository;
    @Autowired private NotebookRepository notebookRepository;

    @Override
    public void run(String... args) throws Exception {
        // Solo ejecutar el seeder si la tabla principal (Admin) está vacía
        if (adminRepository.count() == 0) {
            System.out.println("Iniciando seeder de base de datos");
            
            // Llama a los métodos de siembra
            seedAdmins();
            seedClientes();
            seedRegiones();
            seedAudifonos();
            seedMouses();
            seedTeclados();
            seedNotebooks();
            
            System.out.println("Seeder completado exitosamente!");
        } else {
            System.out.println("La base de datos ya contiene datos. Seeder omitido.");
        }
    }

    private void seedAdmins() {
        // Datos de la tabla 'admin' (1 fila)
        AdminModel admin1 = new AdminModel();
        // Nota: se omite el setID y se deja que Spring Data genere el ID automáticamente
        admin1.setNombre("adminadmin"); 
        admin1.setRol("admin");
        admin1.setCorreo("admin@levelup.com");
        admin1.setContraseña("admin123"); 
        adminRepository.save(admin1);

        System.out.println("Admins creados: " + adminRepository.count());
    }

    private void seedClientes() {
        // Datos de la tabla 'cliente' (3 filas)
        
        ClienteModel cliente1 = new ClienteModel();
        cliente1.setNombre("Enzo");
        cliente1.setRol("cliente");
        cliente1.setCorreo("enzo123@gmail.com");
        cliente1.setContraseña("enzo123");
        clienteRepository.save(cliente1);

        ClienteModel cliente2 = new ClienteModel();
        cliente2.setNombre("Fabian");
        cliente2.setRol("cliente");
        cliente2.setCorreo("fabian123@gmail.com");
        cliente2.setContraseña("fabian123");
        clienteRepository.save(cliente2);

        ClienteModel cliente3 = new ClienteModel();
        cliente3.setNombre("Maximiliano");
        cliente3.setRol("cliente");
        cliente3.setCorreo("maximiliano123@gmail.com");
        cliente3.setContraseña("maxi123");
        clienteRepository.save(cliente3);

        System.out.println("Clientes creados: " + clienteRepository.count());
    }

    private void seedRegiones() {
        // Datos de la tabla 'region' (16 filas)
        String[] regiones = {
            "Arica y Parinacota", "Tarapacá", "Antofagasta", "Atacama",
            "Coquimbo", "Valparaíso", "Metropolitana de Santiago", "Libertador General Bernardo OHiggins",
            "Maule", "Nuble", "Biobío", "La Araucanía",
            "Los Ríos", "Los Lagos", "Aysén del General Carlos Ibáñez del Campo", "Magallanes y de la Antártica Chilena"
        };

        for (String nombreRegion : regiones) {
            Region region = new Region();
            region.setNombre(nombreRegion);
            regionRepository.save(region);
        }

        System.out.println("Regiones creadas: " + regionRepository.count());
    }

    private void seedAudifonos() {
        // Datos de la tabla 'audifono' (2 filas)
        
        AudifonoModel audifono1 = new AudifonoModel();
        audifono1.setNombre("Audífonos Gamer Rgb Altec Lansing Gh9602");
        audifono1.setCategoria("Audífonos");
        audifono1.setMarca("Altec Lansing");
        audifono1.setPrecio(30990);
        audifono1.setStock(50);
        audifono1.setInalambrico("No");
        audifono1.setColor("Negro");
        audifono1.setBotonesCant(3);
        audifono1.setDescripcion("Los audífonos Gamers de Altec Lansing ALGH9602 con USB 7.1 son flexibles y están diseñados para durar.");
        audifono1.setUrlImagen("https://www.hites.com/on/demandware.static/-/Sites-mastercatalog_HITES/default/dw64a8ce06/images/original/mkp/1017300180100/10173001801001_1.jpg");
        audifonoRepository.save(audifono1);

        AudifonoModel audifono2 = new AudifonoModel();
        audifono2.setNombre("Audifonos Gamer Monster");
        audifono2.setCategoria("Audífonos");
        audifono2.setMarca("Monster");
        audifono2.setPrecio(8000);
        audifono2.setStock(35);
        audifono2.setInalambrico("No");
        audifono2.setColor("Negro");
        audifono2.setBotonesCant(3);
        audifono2.setDescripcion("Audífonos Gamer Monster Loud 550BK. Formato Headset, con micrófono, compatible con Ps4 / Nswitch / X-one.");
        audifono2.setUrlImagen("https://media.falabella.com/falabellaCL/146608981_01/w=800,h=800,fit=pad");
        audifonoRepository.save(audifono2);

        System.out.println("Audífonos creados: " + audifonoRepository.count());
    }

    private void seedMouses() {
        // Datos de la tabla 'mouse' (2 filas)

        MouseModel mouse1 = new MouseModel();
        mouse1.setNombre("Mouse Gamer Monster RGB");
        mouse1.setCategoria("Mouse");
        mouse1.setMarca("Monster");
        mouse1.setPrecio(7590);
        mouse1.setStock(25);
        mouse1.setInalambrico("No");
        mouse1.setColor("Negro");
        mouse1.setBotonesCant(6);
        mouse1.setDpiMin(100);
        mouse1.setDpiMax(1000); // 1000 DPI según los datos del script SQL
        mouse1.setDescripcion("Mouse Gamer Monster RGB Wired. Diseño ergonómico con iluminación RGB personalizable y 6 botones programables.");
        mouse1.setUrlImagen("https://i.bolder.run/r/czozMjIxLGc6NjkweA/477efa0d/711248-Mouse_B1.png");
        mouseRepository.save(mouse1);

        MouseModel mouse2 = new MouseModel();
        mouse2.setNombre("Mouse Razer Cobra Pro HyperSpeed");
        mouse2.setCategoria("Mouse");
        mouse2.setMarca("Razer");
        mouse2.setPrecio(124990);
        mouse2.setStock(15);
        mouse2.setInalambrico("No");
        mouse2.setColor("Negro");
        mouse2.setBotonesCant(5);
        mouse2.setDpiMin(2000); // DPI mínimo 2000 según los datos del script SQL
        mouse2.setDpiMax(20000); // DPI máximo 20000 según los datos del script SQL
        mouse2.setDescripcion("El Razer Cobra Pro HyperSpeed es un mouse gamer inalámbrico que ofrece una precisión excepcional y una conectividad sin interrupciones gracias a la tecnología HyperSpeed de Razer.");
        mouse2.setUrlImagen("https://www.winpy.cl/files/w38389_razer_cobra_pro_hyperspeed_00.jpg");
        mouseRepository.save(mouse2);

        System.out.println("Mouses creados: " + mouseRepository.count());
    }

    private void seedTeclados() {
        // Datos de la tabla 'teclado' (2 filas)

        TecladoModel teclado1 = new TecladoModel();
        teclado1.setNombre("Teclado Gamer Redragon Kumara");
        teclado1.setCategoria("Teclado");
        teclado1.setMarca("Redragon");
        teclado1.setPrecio(35990);
        teclado1.setStock(40);
        teclado1.setColor("Negro");
        teclado1.setInalambrico("No");
        teclado1.setDimension(75);
        teclado1.setTipo("Mecanico");
        teclado1.setSwitches("Mechanical Outemu Blue");
        teclado1.setDescripcion("La iluminación del Kumara K-552 RGB consta de teclas retroiluminadas configurables mediante software independiente.");
        teclado1.setUrlImagen("https://i.bolder.run/r/czozMjIxLGc6NjkweA/2d37a7fc/736207-Kumara1.png");
        tecladoRepository.save(teclado1);

        TecladoModel teclado2 = new TecladoModel();
        teclado2.setNombre("Teclado Mecanico Gamer RK Royal Kludge R65");
        teclado2.setCategoria("Teclado");
        teclado2.setMarca("Royal Kludge");
        teclado2.setPrecio(57990);
        teclado2.setStock(15);
        teclado2.setColor("Negro");
        teclado2.setInalambrico("Si");
        teclado2.setDimension(65);
        teclado2.setTipo("Mecanico");
        teclado2.setSwitches("Mechanical RK Blue");
        teclado2.setDescripcion("Diseñado para gamers y creadores que buscan control total y rendimiento insuperable. Ideal para aficionados, semiprofesionales y profesionales.");
        teclado2.setUrlImagen("https://www.chilegatillos.cl/cdn/shop/files/TecladoRKRoyalKludgeR65chilegatillos.cl.jpg?v=1717042966&width=2048");
        tecladoRepository.save(teclado2);

        System.out.println("Teclados creados: " + tecladoRepository.count());
    }

    private void seedNotebooks() {
        // Datos de la tabla 'notebook' (1 fila)

        NotebookModel notebook1 = new NotebookModel();
        notebook1.setNombre("Gamer Nitro V15 RTX 2050");
        notebook1.setCategoria("Notebook");
        notebook1.setMarca("Acer");
        notebook1.setPrecio(549990);
        notebook1.setStock(15);
        notebook1.setColor("Negro");
        notebook1.setProcesador("Intel Core i5-12500H");
        notebook1.setRam("16gb");
        notebook1.setMemoria("512GB SSD");
        notebook1.setTarjetaVideo("NVIDIA GeForce RTX 2050");
        notebook1.setDescripcion("Notebook gamer con Windows 11, 512GB de almacenamiento, 16GB RAM y pantalla FHD de 15,6 pulgadas.");
        notebook1.setUrlImagen("https://www.acerstore.cl/cdn/shop/files/1_ANV15-51-53W1-1.png?v=1753392522&width=533");
        notebookRepository.save(notebook1);

        System.out.println("Notebooks creados: " + notebookRepository.count());
    }
}