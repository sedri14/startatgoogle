package DesignPatterns.Visitor;

import com.google.gson.Gson;

class ExportToJsonVisitor implements Visitor{
    @Override
    public String visit(User user) {
        Gson gson = new Gson();
        return gson.toJson(user);
    }

    @Override
    public String visit(Asset asset) {
        Gson gson = new Gson();
        return gson.toJson(asset);
    }

    @Override
    public String visit(Group group) {
        Gson gson = new Gson();
        return gson.toJson(group);
    }
}
