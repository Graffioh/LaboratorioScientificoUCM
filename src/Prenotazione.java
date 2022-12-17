import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class Prenotazione {
	private LocalDate data;
	private LocalTime ora;
	private String tempoUso;
	private UUID codP = UUID.randomUUID();
}
