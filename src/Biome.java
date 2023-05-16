package src;

import java.util.*;
import java.util.Map;
import java.util.HashMap;

public class Biome {
//17 WARNINGS MA TEN KOD XDDD
    private Set<int[]> area;
    private Map<Resource, Integer> resources;
    private int id = 0;
    private static int quantity = 0;
    private BiomeType type;
    private List<Building> buildings;

    public enum BiomeType {
        meadow, forest, wasteland
    }

    public enum Building {
        sawmill, farm, fortress, barracks
    }

    public enum Resource {
        wood, soldiers, food
    }

    public Biome(int[] a, BiomeType type) {
        area = new HashSet<>();
        area.add(a);
        quantity++;
        id = quantity;
        this.type = type;
        buildings = new ArrayList<>();
        resources = new HashMap<>();
    }


    public Set<int[]> getArea() {
        return area;
    }

    public void addArea(int[] x) {
        area.add(x);
    }

    public Map<Resource, Integer> getResources() {
        updateResources();
        return resources;
    }

    public BiomeType getType() {
        return type;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public void build(Building building) {
        if (building == Building.sawmill && type != BiomeType.forest) {
            System.out.println("Gdzie z tym tartakiem.");
            return;
        }
        if (building == Building.farm && type != BiomeType.meadow) {
            System.out.println("Gdzie z tą farmą.");
            return;
        }
        buildings.add(building);
        }
        private void updateResources() {
            for (Building building : buildings) {
                if (building == Building.sawmill) {
                    resources.put(Resource.wood, resources.getOrDefault(Resource.wood, 0) + 2);
                }
                if (building == Building.barracks) {
                    resources.put(Resource.soldiers, resources.getOrDefault(Resource.soldiers, 0) + 1);
                }
                if (building == Building.farm) {
                    resources.put(Resource.food, resources.getOrDefault(Resource.food, 0) + 2);
                }
            }
        }
}
