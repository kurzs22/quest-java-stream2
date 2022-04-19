import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Shield {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.add("Phil Coulson");
        names.add("Melinda May");
        names.add("Daisy Johnson");
        names.add("Leopold Fitz");
        names.add("Jemma Simmons");

        // 1 : map names to agents list
        List<Agent> agents = new ArrayList<>();
        Function<String, Agent> names2agents = s -> {
            String[] parts = s.split(" ");
            String firstname = parts.length > 0 ? parts[0] : "";
            String lastname = parts.length > 1 ? parts[1] : "";
            return new Agent(firstname, lastname);
        };
        agents = names.stream()
                .map(names2agents)
                .collect(Collectors.toList());

        showAgents(agents);
    }

    // don't touch anything here !
    private static void showAgents(List<Agent> agents) {
        System.out.println("\nAgents:");
        for (Agent agent : agents) {
            System.out.println(agent.getLastName() + " " + agent.getFirstName());
        }
    }
}