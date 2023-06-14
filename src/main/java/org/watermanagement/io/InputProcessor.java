package org.watermanagement.io;

import org.watermanagement.io.utils.Functionality;
import org.watermanagement.service.command.Actions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class InputProcessor {
    private Map<Actions, Consumer<String>> commands = new HashMap();

    public InputProcessor(Functionality useCases) {
        commands.put(Actions.ALLOT_WATER, useCases::allocateWater);
        commands.put(Actions.ADD_GUESTS, useCases::addGuests);
        commands.put(Actions.BILL, useCases::calculateBill);
    }

    public List<Runnable> parse(String filePath) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        return lines.stream().map(this::registerCommands)
                .collect(Collectors.toList());
    }

    private Runnable registerCommands(String lineInput) {
        String commandName = lineInput.split(" ")[0];
        Consumer<String> consumer = commands.get(Actions.valueOf(commandName));
        return () -> consumer.accept(lineInput);
    }
}
