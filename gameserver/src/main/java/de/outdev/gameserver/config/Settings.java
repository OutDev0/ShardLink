package de.outdev.gameserver.config;

import de.exlll.configlib.Comment;
import de.exlll.configlib.Configuration;
import lombok.Getter;

@Configuration
@Getter
public final class Settings {
    @Comment("Database Type:")
    private String Type = "MySQL";

    @Comment("\nDatabase Host:")
    private String Host = "localhost";

    @Comment("\nDatabase Port:")
    private int Port = 3306;

    @Comment("\nDatabase Name:")
    private String Name = "ShardLink";

    @Comment("\nDatabase Username:")
    private String Username = "root";

    @Comment("\nDatabase Password:")
    private String Password = "password";

    @Comment("\nDatabase Connection Pool Size:")
    private int connectionPoolSize = 20;
}
