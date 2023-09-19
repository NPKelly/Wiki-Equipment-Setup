package com.wymoros.wikisetup;

import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.util.ImageUtil;

@Slf4j
@PluginDescriptor(
	name = "Wiki Equipment Setup"
)
public class WikiEquipmentSetupPlugin extends Plugin
{
	private static final BufferedImage ICON = ImageUtil.loadImageResource(WikiEquipmentSetupPlugin.class, "wes.png");

	@Inject
	private Client client;

	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	private WikiEquipmentSetupConfig config;

	private WikiEquipmentSetupPanel panel;
	private NavigationButton navButton;

	@Override
	protected void startUp() throws Exception
	{
		log.info("Wiki Equipment Setup started!");

		panel = new WikiEquipmentSetupPanel(client, config);
		navButton = NavigationButton.builder()
				.tooltip("Wiki Equipment Setup")
				.icon(ICON)
				.priority(6)
				.panel(panel)
				.build();

		clientToolbar.addNavigation(navButton);
	}

	@Override
	protected void shutDown() throws Exception
	{
		log.info("Wiki Equipment Setup stopped!");
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
		{
			client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Wiki Equipment Setup says " + config.greeting(), null);
		}
	}

	@Provides
	WikiEquipmentSetupConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(WikiEquipmentSetupConfig.class);
	}
}
