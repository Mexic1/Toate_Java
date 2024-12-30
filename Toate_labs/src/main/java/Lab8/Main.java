package Lab8;

import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/lab8";
        try {
            Connection connection = DriverManager.getConnection(url, "Mexic", "Mexic1");
            Statement statement = connection.createStatement();

            //afisare_tabela(statement, "Continut initial");


            Scanner sc = new Scanner(System.in);
             while(true)
             {
                 System.out.println("0. Iesire");
                 System.out.println("1. Adaugare tabela persoane");
                 System.out.println("2. Adaugare excursie");
                 System.out.println("3. Afisarea persoanelor si la fiecare persoanei a excursiilor");
                 System.out.println("4. Afisare excursii la o anumita persoana");
                 System.out.println("5. Afisare persoane care au vizitat o anumita locatie");
                 System.out.println("6. Afisare persoane care au excursii intr-un anumit an");
                 System.out.println("7. Stergerea unei excursii");
                 System.out.println("8. Stergerea unei persoane cu tot cu excursii");
                 System.out.println("Optiunea dvs:");
                    int optiune = sc.nextInt();
                    switch (optiune) {
                        case 0:
                            statement.close();
                            connection.close();
                            System.exit(0);
                            break;
                        case 1:
                            System.out.println("Introduceti id-ul persoanei:");
                            int id = sc.nextInt();
                            System.out.println("Introduceti numele persoanei:");
                            String nume = sc.next();
                            System.out.println("Introduceti varsta persoanei:");
                            int varsta = sc.nextInt();
                            adaugare_persoana(connection, id, nume, varsta);
                            break;

                        case 2:
                            System.out.println("Introduceti id-ul excursiei:");
                            int id_ex = sc.nextInt();
                            System.out.println("Introduceti id-ul persoanei:");
                            int id_pers = sc.nextInt();

                            String sql = "select id from persoana where id=" + id_pers;
                            ResultSet rs = statement.executeQuery(sql);
                            if (!rs.next()) {
                                System.out.println("Persoana cu id-ul " + id_pers + " nu exista");
                                break;
                            }

                            System.out.println("Introduceti locatia excursiei:");
                            String locatie = sc.next();
                            System.out.println("Introduceti anul excursiei:");
                            int an_ex = sc.nextInt();
                            System.out.println(an_ex);
                            adaugare_excursie(connection, id_ex, id_pers, locatie, an_ex);
                            break;

                        case 3:
                            afisare_persoane(statement);
                            break;
                        case 4:
                            System.out.println("Numele persoanei");
                            String nume_pers = sc.next();
                            excursii_persona(statement, nume_pers);
                            break;
                        case 5:
                            System.out.println("Locatia:");
                            String destinatie = sc.next();
                            persoana_desti(statement, destinatie);
                            break;
                        case 6:
                            System.out.println("Anul:");
                            int an = sc.nextInt();
                            persoane_an(statement, an);
                            break;
                        case 7:
                            System.out.println("Introduceti id-ul excursiei:");
                            int id_excursie = sc.nextInt();
                            stergere_excursie(statement, id_excursie);
                            break;
                        case 8:
                            System.out.println("Introduceti id-ul persoanei:");
                            int id_persoana = sc.nextInt();
                            stergere_persoana(statement, id_persoana);
                            break;
                        default:
                            System.out.println("Optiune invalida");
                            break;
                    }
             }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void adaugare_persoana(Connection connection, int id, String nume, int varsta) {
        String sql="insert into persoana values (?,?,?)";
        try(PreparedStatement ps=connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, nume);
            ps.setInt(3, varsta);
            int nr_randuri=ps.executeUpdate();
            System.out.println("\nNumar randuri afectate de adaugare="+nr_randuri);
        } catch (SQLException e) {
            System.out.println(sql);
            e.printStackTrace();
        }
    }

    public static void adaugare_excursie(Connection connection, int id_ex,int id_pers, String locatie, int an) {
        String sql="insert into excursii values (?,?,?,?)";
        try(PreparedStatement ps=connection.prepareStatement(sql)) {
            ps.setInt(1, id_ex);
            ps.setInt(2, id_pers);
            ps.setString(3, locatie);
            ps.setInt(4, an);
            int nr_randuri=ps.executeUpdate();
            System.out.println("\nNumar randuri afectate de adaugare="+nr_randuri);
        } catch (SQLException e) {
            System.out.println(sql);
            e.printStackTrace();
        }
    }

    public static void afisare_persoane(Statement statement) {
        String sql ="select * from persoana";
        int id=0;
        try(ResultSet rs =statement.executeQuery(sql)) {
            while (rs.next()) {
               id= rs.getInt(1);
                System.out.println("id=" + id + ", nume=" + rs.getString(2) + ", varsta=" + rs.getInt(3));
                //   System.out.println("\n");


                String sql1 ="select * from excursii where id_persoana="+id;
                try(Statement statement1 = statement.getConnection().createStatement();
                        ResultSet rs1 =statement1.executeQuery(sql1)) {
                    while (rs1.next())
                        System.out.println("id_excursie=" + rs1.getInt(1) +" id_persoana=" + rs1.getInt(2)+ ", Locatia=" + rs1.getString(3) + ", Anul=" + rs1.getInt(4));
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void excursii_persona(Statement statement,String nume_persona) {
        String sql = "select id from persoana where nume='" + nume_persona + "'";
        try (ResultSet rs = statement.executeQuery(sql)) {
            if (!rs.next()) {
                System.out.println("Persoana cu numele " + nume_persona + " nu exista");
                return;
            }
            int id = rs.getInt(1);
            String sql1 = "select * from excursii where id_persoana=" + id;
            try (Statement statement1 = statement.getConnection().createStatement();
                 ResultSet rs1 = statement1.executeQuery(sql1)) {
                while (rs1.next())
                    System.out.println("id_excursie=" + rs1.getInt(1) + " id_persoana=" + rs1.getInt(2) + ", Locatia=" + rs1.getString(3) + ", Anul=" + rs1.getInt(4));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void persoana_desti(Statement statement,String loc)
    {
        String sql="select * from excursii where Destinatia='"+loc+"'";
        try(ResultSet rs=statement.executeQuery(sql)) {
            while (rs.next()) {
                // System.out.println("id_excursie=" + rs.getInt(1) + " id_persoana=" + rs.getInt(2) + ", Locatia=" + rs.getString(3) + ", Anul=" + rs.getInt(4));
                int id_pers = rs.getInt(2);

                String sql1 = "select * from persoana where id=" + id_pers;
                try (Statement statement1 = statement.getConnection().createStatement();
                     ResultSet rs1 = statement1.executeQuery(sql1)) {
                    while (rs1.next())
                        System.out.println("id=" + rs1.getInt(1) + ", nume=" + rs1.getString(2) + ", varsta=" + rs1.getInt(3));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void persoane_an(Statement statement,int an) {
        String url = "select * from excursii where Anul=" + an;
        try (ResultSet rs = statement.executeQuery(url)) {
            while (rs.next()) {
                int id_pers = rs.getInt(2);

                String sql1 = "select * from persoana where id=" + id_pers;
                try (Statement statement1 = statement.getConnection().createStatement();
                     ResultSet rs1 = statement1.executeQuery(sql1)) {
                    while (rs1.next())
                        System.out.println("id=" + rs1.getInt(1) + ", nume=" + rs1.getString(2) + ", varsta=" + rs1.getInt(3));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void stergere_excursie(Statement statement, int id_excursie) {
        String sql = "delete from excursii where id_excursie=" + id_excursie;
        try {
            int nr_randuri = statement.executeUpdate(sql);
            System.out.println("\nNumar randuri afectate de stergere=" + nr_randuri);
        } catch (SQLException e) {
            System.out.println(sql);
            e.printStackTrace();
        }
    }

    public static void stergere_persoana(Statement statement, int id_persoana) {
        String sql = "delete from persoana where Id=" + id_persoana;
        try {
            int nr_randuri = statement.executeUpdate(sql);
            System.out.println("\nNumar randuri afectate de stergere=" + nr_randuri);
        } catch (SQLException e) {
            System.out.println(sql);
            e.printStackTrace();
        }
    }
}