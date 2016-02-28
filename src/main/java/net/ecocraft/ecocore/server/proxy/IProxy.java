package net.ecocraft.ecocore.server.proxy;

public interface IProxy {
    void onPreInit();

    void onInit();

    void onPostInit();
}
