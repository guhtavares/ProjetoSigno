import java.time.*;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
       mapaAstral(menu());
    }


    private static LocalDateTime menu() {
        Scanner sc = new Scanner(System.in);

        System.out.println("----------------Mapa Astral----------------");

        System.out.print("Digite o ano de nascimento: ");
        Integer dataNascimento = sc.nextInt();

        System.out.print("Mes de nascimento: ");
        Integer mesDeNascimento = sc.nextInt();

        System.out.print("Dia de nascimento: ");
        Integer diaDeNascimento = sc.nextInt();

        System.out.println("------------------------------------");

        System.out.print("Digite a hora de nascimento: ");
        Integer horaDeNascimento = sc.nextInt();

        System.out.print("Digite o minuto de nascimento: ");
        Integer minutoDeNascimento = sc.nextInt();


        LocalDateTime resultMapa = LocalDateTime.of(dataNascimento, mesDeNascimento, diaDeNascimento, horaDeNascimento, minutoDeNascimento);

        return resultMapa;
    }

    private static String signo(LocalDate dataNascimento) {
        MonthDay monthDayNascimento = MonthDay.of(dataNascimento.getMonth(), dataNascimento.getDayOfMonth());

        MonthDay ariesStartDate = MonthDay.of(3, 21);
        MonthDay ariesEndDate = MonthDay.of(4, 20);

        MonthDay touroStartDate = MonthDay.of(4, 21);
        MonthDay touroEndDate = MonthDay.of(5, 20);

        MonthDay gemeosStartDate = MonthDay.of(5, 21);
        MonthDay gemeosEndDate = MonthDay.of(6, 20);

        MonthDay cancerStartDate = MonthDay.of(6, 21);
        MonthDay cancerEndDate = MonthDay.of(7, 22);

        MonthDay leaoStartDate = MonthDay.of(7, 23);
        MonthDay leaoEndDate = MonthDay.of(8, 22);

        MonthDay virgemStartDate = MonthDay.of(8, 23);
        MonthDay virgemEndDate = MonthDay.of(9, 22);

        MonthDay libraStartDate = MonthDay.of(9, 23);
        MonthDay libraEndDate = MonthDay.of(10, 22);

        MonthDay escorpiaoStartDate = MonthDay.of(10, 23);
        MonthDay escorpiaoEndDate = MonthDay.of(11, 21);

        MonthDay sagitarioStartDate = MonthDay.of(11, 22);
        MonthDay sagitarioEndDate = MonthDay.of(12, 21);

        MonthDay capriconioStartDate = MonthDay.of(12, 22);
        MonthDay capriconioEndDate = MonthDay.of(1, 19);

        MonthDay aquarioStartDate = MonthDay.of(1, 20);
        MonthDay aquarioEndDate = MonthDay.of(2, 18);

        MonthDay peixeStartDate = MonthDay.of(2, 19);
        MonthDay peixeEndDate = MonthDay.of(3, 20);


        if (isWithinRange(monthDayNascimento, ariesStartDate, ariesEndDate)) {
            return "Aries";
        } else if (isWithinRange(monthDayNascimento, touroStartDate, touroEndDate)) {
            return "Touro";
        } else if (isWithinRange(monthDayNascimento, escorpiaoStartDate, escorpiaoEndDate)) {
            return "Escorpiao";
        } else if (isWithinRange(monthDayNascimento, gemeosStartDate, gemeosEndDate)) {
            return "Gemeos";
        }  else if (isWithinRange(monthDayNascimento, cancerStartDate, cancerEndDate)) {
            return "Cancer";
        }else if (isWithinRange(monthDayNascimento, leaoStartDate, leaoEndDate)) {
            return "Leao";
        }else if (isWithinRange(monthDayNascimento, virgemStartDate, virgemEndDate)) {
            return "Virgem";
        }else if (isWithinRange(monthDayNascimento, libraStartDate, libraEndDate)) {
            return "Libra";
        }else if (isWithinRange(monthDayNascimento, escorpiaoStartDate, escorpiaoEndDate)) {
            return "Escorpiao";
        }else if (isWithinRange(monthDayNascimento, sagitarioStartDate, sagitarioEndDate)) {
            return "Sagitario";
        }else if (isWithinRange(monthDayNascimento, capriconioStartDate, capriconioEndDate)) {
            return "Capricornio";
        }else if (isWithinRange(monthDayNascimento, aquarioStartDate, aquarioEndDate)) {
            return "Aquario";
        }else if (isWithinRange(monthDayNascimento, peixeStartDate, peixeEndDate)) {
            return "Peixes";
        }

        return "Não tem Signo !! ";

    }


    private static boolean isWithinRange(MonthDay dataNascimento, MonthDay startDate, MonthDay endData) {
        return !(dataNascimento.isBefore(startDate) || dataNascimento.isAfter(endData));
    }

    private static boolean isWithinRange(LocalTime horarioDeNascimento, LocalTime startTime, LocalTime endTime) {
        return !(horarioDeNascimento.isBefore(startTime) || horarioDeNascimento.isAfter(endTime));
    }


    private static String ascendente(String signo, LocalTime horarioDeNascimento) {

        if ("Aries".equalsIgnoreCase(signo)) {
            if (isWithinRange(horarioDeNascimento, LocalTime.of(18, 31), LocalTime.of(20, 30))) {
                return "Escorpião";
            }
        } else if ("Sagitario".equalsIgnoreCase(signo)) {
            if (isWithinRange(horarioDeNascimento, LocalTime.of(18, 31), LocalTime.of(20, 30))) {
                return "Peixes";
            }
        } else if ("Aquario".equalsIgnoreCase(signo)) {
            if (isWithinRange(horarioDeNascimento, LocalTime.of(18, 31), LocalTime.of(20, 30))) {
                return "Saturno";
            }
        }

        return "Não tem ascendente! ";
    }

    public static void mapaAstral(LocalDateTime dataHorasNascimento) {
        Period idade = Period.between(dataHorasNascimento.toLocalDate(), LocalDate.now());


        System.out.println("-----------------------------------");
        System.out.println("Data de nascimento: " + dataHorasNascimento);
        System.out.println("Idade atual: " + idade);
        System.out.println("Ano bissexto: " + dataHorasNascimento.toLocalDate().isLeapYear());
        System.out.println("Signo: " + signo(dataHorasNascimento.toLocalDate()));


        if (dataHorasNascimento.getYear() > 1976) {
            System.out.println("Ascendente: " + ascendente(signo(dataHorasNascimento.toLocalDate()), dataHorasNascimento.toLocalTime().minusHours(2)));
        } else if (dataHorasNascimento.getYear() > 1946 && dataHorasNascimento.getYear() < 1975) {
            System.out.println("Ascendente: " + ascendente(signo(dataHorasNascimento.toLocalDate()), dataHorasNascimento.toLocalTime().minusHours(2)));
        } else {
            System.out.println("Ascendente: " + ascendente(signo(dataHorasNascimento.toLocalDate()), dataHorasNascimento.toLocalTime()));
        }

        System.out.println("------------------------------");
    }

}
