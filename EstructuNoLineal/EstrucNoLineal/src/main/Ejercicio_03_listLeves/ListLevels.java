package main.Ejercicio_03_listLeves;

import main.Materia.Models.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class ListLevels {

    public ListLevels(Object object) {
        
    }

    public List<List<Node>> listLevels(Node root) {
        List<List<Node>> result = new ArrayList<>();
        listLevel(root, 0, result);
        return result;
    }

    private void listLevel(Node node, int level, List<List<Node>> result) {
        if (node == null) {
            return;
        }

        if (result.size() == level) {
            result.add(new LinkedList<>());
        }

        result.get(level).add(node);

        listLevel(node.getLeft(), level + 1, result);
        listLevel(node.getRight(), level + 1, result);
    }
}
