package com.example.Laboratorul10;

import com.example.Laboratorul10.CarteRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.Laboratorul10.Carte;

import java.util.List;
import java.util.Optional;

@Controller
public class CarteWebController {
    @Autowired
    CarteRepository repository;

    @GetMapping("/")
    public String carti(Model model) {

        List<Carte> c=repository.findAll();

        String s = "Lista cartilor preluate prin repository";
        model.addAttribute("carte", new Carte());
        model.addAttribute("str", s);
        model.addAttribute("lista", c);
        return "carti";
    }

    @PostMapping("/operatii")
    public String operatii(@ModelAttribute Carte carte,
                           //butoanele de submit din formular
                           @RequestParam(value = "adauga", required = false) String adauga,
                           @RequestParam(value = "modifica", required = false) String modifica,
                           @RequestParam(value = "sterge", required = false) String sterge,
                           @RequestParam(value = "filtreaza", required = false) String filtreaza,
                           Model model) {

        if (adauga != null) {
            try {
                if(carte.getId()!=null && carte.getId()!=0)
                {
                    carte.setId(null);
                    System.out.println("Id-ul a fost setat la null");
                }
                repository.save(carte);
                return "redirect:/";
            } catch (Exception e) {
                model.addAttribute("error", "Cartea a fost modificată de altcineva între timp. Te rugăm să reîncarci pagina.");
                model.addAttribute("carti", repository.findAll());
                return "carti";
            }
        }

        if(modifica != null) {
            try {
                System.out.println("Modificare carte");
                repository.save(carte);
                return "redirect:/";
            } catch (Exception e) {
                model.addAttribute("error", "A apărut o eroare la modificarea cărții: " + e.getMessage());
                model.addAttribute("carte", carte);
                model.addAttribute("lista", repository.findAll());
                return "carti";
            }
        }

        if(sterge != null) {
            try {
                System.out.println("Stergere carte");
                repository.deleteById(carte.getId());
                return "redirect:/";
            } catch (Exception e) {
                model.addAttribute("error", "A apărut o eroare la ștergerea cărții: " + e.getMessage());
                model.addAttribute("carte", carte);
                model.addAttribute("lista", repository.findAll());
                return "carti";
            }
        }

        if(filtreaza!=null)
        {
            try {
                List<Carte> cartiAutor = repository.findAll();
                cartiAutor = cartiAutor.stream().filter(c -> c.getAutorul().equals(carte.getAutorul())).toList();
                cartiAutor.forEach(System.out::println);
                model.addAttribute("carte", new Carte());
                model.addAttribute("lista", cartiAutor);
                model.addAttribute("str", "Cărţile următoare aparţin autorului " + carte.getAutorul() + ".");
            }catch (Exception e)
            {
                model.addAttribute("error", "A apărut o eroare la filtrarea cărților: " + e.getMessage());
                model.addAttribute("carte", carte);
                model.addAttribute("lista", repository.findAll());
                return "carti";
            }
        }


        System.out.println("Modificare carte");
        return "carti";

    }

}
