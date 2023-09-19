package com.wymoros.wikisetup;

import java.awt.GridBagLayout;

import javax.swing.border.EmptyBorder;

import net.runelite.api.Client;
import net.runelite.client.ui.PluginPanel;

public class WikiEquipmentSetupPanel extends PluginPanel {

    public WikiEquipmentSetupPanel(Client client, WikiEquipmentSetupConfig config) {
        super();


        setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(new GridBagLayout());
    }

}
