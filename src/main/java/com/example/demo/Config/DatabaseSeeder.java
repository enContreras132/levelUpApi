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
    @Autowired private ComunaRepository comunaRepository;
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
            seedComunas();
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

    private void seedComunas() {
        // Obtener todas las regiones desde la base de datos
        java.util.List<Region> regiones = regionRepository.findAll();
        
        String[][] comunasData = {
            // {nombre, id_region}
            // 1. Arica y Parinacota
            {"Arica", "1"}, {"Camarones", "1"}, {"Putre", "1"}, {"General Lagos", "1"},
            
            // 2. Tarapacá
            {"Iquique", "2"}, {"Alto Hospicio", "2"}, {"Pozo Almonte", "2"}, {"Camiña", "2"}, 
            {"Colchane", "2"}, {"Huara", "2"}, {"Pica", "2"},
            
            // 3. Antofagasta
            {"Antofagasta", "3"}, {"Mejillones", "3"}, {"Sierra Gorda", "3"}, {"Taltal", "3"}, 
            {"Calama", "3"}, {"Ollagüe", "3"}, {"San Pedro de Atacama", "3"}, {"Tocopilla", "3"}, 
            {"María Elena", "3"},
            
            // 4. Atacama
            {"Copiapó", "4"}, {"Caldera", "4"}, {"Tierra Amarilla", "4"}, {"Chañaral", "4"}, 
            {"Diego de Almagro", "4"}, {"Vallenar", "4"}, {"Alto del Carmen", "4"}, {"Freirina", "4"}, 
            {"Huasco", "4"},
            
            // 5. Coquimbo
            {"La Serena", "5"}, {"Coquimbo", "5"}, {"Andacollo", "5"}, {"La Higuera", "5"}, 
            {"Paihuano", "5"}, {"Vicuña", "5"}, {"Illapel", "5"}, {"Canela", "5"}, 
            {"Los Vilos", "5"}, {"Salamanca", "5"}, {"Ovalle", "5"}, {"Combarbalá", "5"}, 
            {"Monte Patria", "5"}, {"Punitaqui", "5"}, {"Río Hurtado", "5"},
            
            // 6. Valparaíso
            {"Valparaíso", "6"}, {"Casablanca", "6"}, {"Concón", "6"}, {"Juan Fernández", "6"}, 
            {"Puchuncaví", "6"}, {"Quintero", "6"}, {"Viña del Mar", "6"}, {"Isla de Pascua", "6"}, 
            {"Los Andes", "6"}, {"Calle Larga", "6"}, {"Rinconada", "6"}, {"San Esteban", "6"}, 
            {"La Ligua", "6"}, {"Cabildo", "6"}, {"Papudo", "6"}, {"Petorca", "6"}, 
            {"Zapallar", "6"}, {"Quillota", "6"}, {"Calera", "6"}, {"Hijuelas", "6"}, 
            {"La Cruz", "6"}, {"Nogales", "6"}, {"San Antonio", "6"}, {"Algarrobo", "6"}, 
            {"Cartagena", "6"}, {"El Quisco", "6"}, {"El Tabo", "6"}, {"Santo Domingo", "6"}, 
            {"San Felipe", "6"}, {"Catemu", "6"}, {"Llaillay", "6"}, {"Panquehue", "6"}, 
            {"Putaendo", "6"}, {"Santa María", "6"}, {"Quilpué", "6"}, {"Limache", "6"}, 
            {"Olmué", "6"}, {"Villa Alemana", "6"},
            
            // 7. Metropolitana de Santiago
            {"Cerrillos", "7"}, {"Cerro Navia", "7"}, {"Conchalí", "7"}, {"El Bosque", "7"}, 
            {"Estación Central", "7"}, {"Huechuraba", "7"}, {"Independencia", "7"}, {"La Cisterna", "7"}, 
            {"La Florida", "7"}, {"La Granja", "7"}, {"La Pintana", "7"}, {"La Reina", "7"}, 
            {"Las Condes", "7"}, {"Lo Barnechea", "7"}, {"Lo Espejo", "7"}, {"Lo Prado", "7"}, 
            {"Macul", "7"}, {"Maipú", "7"}, {"Ñuñoa", "7"}, {"Pedro Aguirre Cerda", "7"}, 
            {"Peñalolén", "7"}, {"Providencia", "7"}, {"Pudahuel", "7"}, {"Quilicura", "7"}, 
            {"Quinta Normal", "7"}, {"Recoleta", "7"}, {"Renca", "7"}, {"San Joaquín", "7"}, 
            {"San Miguel", "7"}, {"San Ramón", "7"}, {"Santiago", "7"}, {"Vitacura", "7"}, 
            {"Puente Alto", "7"}, {"Pirque", "7"}, {"San José de Maipo", "7"}, {"Colina", "7"}, 
            {"Lampa", "7"}, {"Til Til", "7"}, {"San Bernardo", "7"}, {"Buin", "7"}, 
            {"Calera de Tango", "7"}, {"Paine", "7"}, {"Melipilla", "7"}, {"Alhué", "7"}, 
            {"Curacaví", "7"}, {"María Pinto", "7"}, {"San Pedro", "7"}, {"Talagante", "7"}, 
            {"El Monte", "7"}, {"Isla de Maipo", "7"}, {"Padre Hurtado", "7"}, {"Peñaflor", "7"},
            
            // 8. Libertador General Bernardo O'Higgins
            {"Rancagua", "8"}, {"Codegua", "8"}, {"Coinco", "8"}, {"Coltauco", "8"}, 
            {"Doñihue", "8"}, {"Graneros", "8"}, {"Las Cabras", "8"}, {"Machalí", "8"}, 
            {"Malloa", "8"}, {"Mostazal", "8"}, {"Olivar", "8"}, {"Peumo", "8"}, 
            {"Pichidegua", "8"}, {"Quinta de Tilcoco", "8"}, {"Rengo", "8"}, {"Requínoa", "8"}, 
            {"San Vicente", "8"}, {"Pichilemu", "8"}, {"La Estrella", "8"}, {"Litueche", "8"}, 
            {"Marchigüe", "8"}, {"Navidad", "8"}, {"Paredones", "8"}, {"San Fernando", "8"}, 
            {"Chépica", "8"}, {"Chimbarongo", "8"}, {"Lolol", "8"}, {"Nancagua", "8"}, 
            {"Palmilla", "8"}, {"Peralillo", "8"}, {"Placilla", "8"}, {"Pumanque", "8"}, 
            {"Santa Cruz", "8"},
            
            // 9. Maule
            {"Talca", "9"}, {"Constitución", "9"}, {"Curepto", "9"}, {"Empedrado", "9"}, 
            {"Maule", "9"}, {"Pelarco", "9"}, {"Pencahue", "9"}, {"Río Claro", "9"}, 
            {"San Clemente", "9"}, {"San Rafael", "9"}, {"Cauquenes", "9"}, {"Chanco", "9"}, 
            {"Pelluhue", "9"}, {"Curicó", "9"}, {"Hualañé", "9"}, {"Licantén", "9"}, 
            {"Molina", "9"}, {"Rauco", "9"}, {"Romeral", "9"}, {"Sagrada Familia", "9"}, 
            {"Teno", "9"}, {"Vichuquén", "9"}, {"Linares", "9"}, {"Colbún", "9"}, 
            {"Longaví", "9"}, {"Parral", "9"}, {"Retiro", "9"}, {"San Javier", "9"}, 
            {"Villa Alegre", "9"}, {"Yerbas Buenas", "9"},
            
            // 10. Ñuble
            {"Cobquecura", "10"}, {"Coelemu", "10"}, {"Ninhue", "10"}, {"Portezuelo", "10"}, 
            {"Quirihue", "10"}, {"Ránquil", "10"}, {"Trehuaco", "10"}, {"Bulnes", "10"}, 
            {"Chillán", "10"}, {"Chillán Viejo", "10"}, {"El Carmen", "10"}, {"Pemuco", "10"}, 
            {"Pinto", "10"}, {"Quillón", "10"}, {"San Ignacio", "10"}, {"Yungay", "10"}, 
            {"Coihueco", "10"}, {"Ñiquén", "10"}, {"San Carlos", "10"}, {"San Fabián", "10"}, 
            {"San Nicolás", "10"},
            
            // 11. Biobío
            {"Concepción", "11"}, {"Coronel", "11"}, {"Chiguayante", "11"}, {"Florida", "11"}, 
            {"Hualqui", "11"}, {"Lota", "11"}, {"Penco", "11"}, {"San Pedro de la Paz", "11"}, 
            {"Santa Juana", "11"}, {"Talcahuano", "11"}, {"Tomé", "11"}, {"Hualpén", "11"}, 
            {"Lebu", "11"}, {"Arauco", "11"}, {"Cañete", "11"}, {"Contulmo", "11"}, 
            {"Curanilahue", "11"}, {"Los Álamos", "11"}, {"Tirúa", "11"}, {"Los Ángeles", "11"}, 
            {"Antuco", "11"}, {"Cabrero", "11"}, {"Laja", "11"}, {"Mulchén", "11"}, 
            {"Nacimiento", "11"}, {"Negrete", "11"}, {"Quilaco", "11"}, {"Quilleco", "11"}, 
            {"San Rosendo", "11"}, {"Santa Bárbara", "11"}, {"Tucapel", "11"}, {"Yumbel", "11"}, 
            {"Alto Biobío", "11"},
            
            // 12. La Araucanía
            {"Temuco", "12"}, {"Carahue", "12"}, {"Cunco", "12"}, {"Curarrehue", "12"}, 
            {"Freire", "12"}, {"Galvarino", "12"}, {"Gorbea", "12"}, {"Lautaro", "12"}, 
            {"Loncoche", "12"}, {"Melipeuco", "12"}, {"Nueva Imperial", "12"}, {"Padre las Casas", "12"}, 
            {"Perquenco", "12"}, {"Pitrufquén", "12"}, {"Pucón", "12"}, {"Saavedra", "12"}, 
            {"Teodoro Schmidt", "12"}, {"Toltén", "12"}, {"Vilcún", "12"}, {"Villarrica", "12"}, 
            {"Cholchol", "12"}, {"Angol", "12"}, {"Collipulli", "12"}, {"Curacautín", "12"}, 
            {"Ercilla", "12"}, {"Lonquimay", "12"}, {"Los Sauces", "12"}, {"Lumaco", "12"}, 
            {"Purén", "12"}, {"Renaico", "12"}, {"Traiguén", "12"}, {"Victoria", "12"},
            
            // 13. Los Ríos
            {"Valdivia", "13"}, {"Corral", "13"}, {"Lanco", "13"}, {"Los Lagos", "13"}, 
            {"Máfil", "13"}, {"Mariquina", "13"}, {"Paillaco", "13"}, {"Panguipulli", "13"}, 
            {"La Unión", "13"}, {"Futrono", "13"}, {"Lago Ranco", "13"}, {"Río Bueno", "13"},
            
            // 14. Los Lagos
            {"Puerto Montt", "14"}, {"Calbuco", "14"}, {"Cochamó", "14"}, {"Fresia", "14"}, 
            {"Frutillar", "14"}, {"Los Muermos", "14"}, {"Llanquihue", "14"}, {"Maullín", "14"}, 
            {"Puerto Varas", "14"}, {"Castro", "14"}, {"Ancud", "14"}, {"Chonchi", "14"}, 
            {"Curaco de Vélez", "14"}, {"Dalcahue", "14"}, {"Puqueldón", "14"}, {"Queilén", "14"}, 
            {"Quellón", "14"}, {"Quemchi", "14"}, {"Quinchao", "14"}, {"Osorno", "14"}, 
            {"Puerto Octay", "14"}, {"Purranque", "14"}, {"Puyehue", "14"}, {"Río Negro", "14"}, 
            {"San Juan de la Costa", "14"}, {"San Pablo", "14"}, {"Chaitén", "14"}, {"Futaleufú", "14"}, 
            {"Hualaihué", "14"}, {"Palena", "14"},
            
            // 15. Aysén
            {"Coyhaique", "15"}, {"Lago Verde", "15"}, {"Aysén", "15"}, {"Cisnes", "15"}, 
            {"Guaitecas", "15"}, {"Cochrane", "15"}, {"O'Higgins", "15"}, {"Tortel", "15"}, 
            {"Chile Chico", "15"}, {"Río Ibáñez", "15"},
            
            // 16. Magallanes
            {"Punta Arenas", "16"}, {"Laguna Blanca", "16"}, {"Río Verde", "16"}, {"San Gregorio", "16"}, 
            {"Cabo de Hornos", "16"}, {"Antártica", "16"}, {"Porvenir", "16"}, {"Primavera", "16"}, 
            {"Timaukel", "16"}, {"Natales", "16"}, {"Torres del Paine", "16"}
        };
        
        for (String[] data : comunasData) {
            ComunaModel comuna = new ComunaModel();
            comuna.setNombre(data[0]);
            int regionId = Integer.parseInt(data[1]);
            comuna.setRegion(regiones.get(regionId - 1)); // Las regiones se crean en orden
            comunaRepository.save(comuna);
        }
        
        System.out.println("Comunas creadas: " + comunaRepository.count());
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