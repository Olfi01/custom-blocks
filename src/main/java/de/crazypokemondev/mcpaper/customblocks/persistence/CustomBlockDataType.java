package de.crazypokemondev.mcpaper.customblocks.persistence;

import de.crazypokemondev.mcpaper.customblocks.CustomBlockData;
import org.bukkit.persistence.PersistentDataAdapterContext;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CustomBlockDataType implements PersistentDataType<String, CustomBlockData[]> {
    public static CustomBlockDataType INSTANCE = new CustomBlockDataType();

    @Override
    public @NotNull Class<String> getPrimitiveType() {
        return String.class;
    }

    @Override
    public @NotNull Class<CustomBlockData[]> getComplexType() {
        return CustomBlockData[].class;
    }

    @Override
    public @NotNull String toPrimitive(@NotNull CustomBlockData @NotNull [] complexes, @NotNull PersistentDataAdapterContext context) {
        return Arrays.stream(complexes).map(complex -> String.format("%d,%d,%d,%s", complex.blockX(),
                complex.blockY(), complex.blockZ(), complex.model())).collect(Collectors.joining("|"));
    }

    @Override
    public @NotNull CustomBlockData @NotNull [] fromPrimitive(@NotNull String primitive, @NotNull PersistentDataAdapterContext context) {
        String[] strings = primitive.split("\\|");
        return (CustomBlockData[]) Arrays.stream(strings).map(str -> {
            String[] split = str.split(",");
            return new CustomBlockData(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]),
                    String.join(",", Arrays.copyOfRange(split, 3, split.length + 1)));
        }).toArray();
    }
}
