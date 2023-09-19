package com.wymoros.wikisetup;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class WikiEquipmentSetupPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(WikiEquipmentSetupPlugin.class);
		RuneLite.main(args);
	}
}