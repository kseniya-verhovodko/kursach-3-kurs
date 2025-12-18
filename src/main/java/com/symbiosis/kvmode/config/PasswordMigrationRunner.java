package com.symbiosis.kvmode.config;//package com.symbiosis.reflection.config;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import com.symbiosis.reflection.model.Registeration;
//import com.symbiosis.reflection.repository.RegisterationRepository;
//
//@Component
//public class PasswordMigrationRunner implements CommandLineRunner {
//
//    @Autowired
//    private RegisterationRepository repo;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Override
//    public void run(String... args) throws Exception {
//        List<Registeration> all = repo.findAll();
//        for (Registeration u : all) {
//            String pwd = u.getPassword();
//            if (pwd != null && !pwd.startsWith("$2a$") && !pwd.startsWith("$2b$") && !pwd.startsWith("$2y$")) {
//                u.setPassword(passwordEncoder.encode(pwd));
//                repo.save(u);
//            }
//        }
//        System.out.println("Password migration finished (if there were plaintext passwords).");
//    }
//}
