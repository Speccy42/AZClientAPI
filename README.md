# AZClientAPI
API & Plugin pour intégrer le AZ Launcher (aka Pactify Launcher).

## Features

* [Intégration des inventaires transparents.](#intégration-des-inventaires-transparents)
* [Manipulation des packets (PLSP Protocol).](#manipulation-des-packets-plsp-protocol)
* [Savoir si un joueur utilise le launcher.](#savoir-si-un-joueur-utilise-le-launcher)
* [Récupérer une couleur au format int (0xAARRGGBB).](#récupérer-une-couleur-au-format-int-0xaarrggbb)

## Installation
> [!WARNING]
> Plugins nécessaires: [AZClientAPI.jar](https://github.com/Speccy42/AZClientAPI/releases) et [ProtocolLib.jar](https://github.com/dmulloy2/ProtocolLib/releases) (dans votre dossier `/plugins`)
### Exemple pour Maven (local)
```xml
<dependencies>
  <dependency>
    <groupId>azclientapi</groupId>
    <artifactId>AZClientAPI</artifactId>
    <version>1.0-SNAPSHOT</version> <!-- Remplacez par la dernière version. -->
    <scope>system</scope>
    <systemPath></systemPath> <!-- Remplacez par le chemin d'accès du plugin. -->
  </dependency>
</dependencies>
```

## Intégration des inventaires transparents
Pour afficher un menu transparent, vous devez ouvrir un inventaire standard et le titre doit contenir `§`
#### Exemple d'inventaire
```java
Inventory inv = Bukkit.createInventory(null, 9, "§rExemple");
player.openInventory(inv);
```

## Manipulation des packets (PLSP Protocol)
#### 1. AllPacketReset ([class info](src/main/java/fr/speccy/azclientapi/bukkit/packets/AllPacketReset.java))
- **Description**: Permet d'annuler toutes les modifications faites par les autres packets.
  ```java
  AllPacketReset.reset(Player player)
  ```

#### 2. PacketConfFlag ([class info](src/main/java/fr/speccy/azclientapi/bukkit/packets/PacketConfFlag.java))
- **Description**: Permet de modifier certains comportements.
  ```java
  PacketConfFlag.setFlag(Player player, String flag, Boolean enabled)
  ```
  - **Liste des comportements (flag)**:
    - "attack_cooldown" (défaut: on) - Activer/Désactiver le cooldown des attaques.
    - "player_push" (défaut: on) - Activer/Désactiver le fait que les joueurs se poussent entre eux.
    - "large_hitbox" (défaut: off) - Activer/Désactiver les hitboxs larges (comme en 1.8).
    - "sword_blocking" (défaut: off) - Activer/Désactiver la parade avec l'épée (pour que ça fonctionne sur un serveur 1.9 il faudra modifier son code).
    - "hit_and_block" (défaut: off) - Activer/Désactiver le hit-and-block.
    - "old_enchantments" (défaut: off) - Activer/Désactiver l'ancienne interface d'enchantement (comme en 1.8).
    - "pvp_hit_priority" (défaut: off) - Activer/Désactiver le fait de donner la priorité au PVP lors des coups (ex: une entité sera ciblée en priorité plutôt qu'une herbe haute).
    - "see_chunks" (défaut: off) - Activer/Désactiver la vision des chunks (le chunk actuel est plus brillant).
    - "sidebar_scores" (défaut: on) - Activer/Désactiver les scores dans la sidebar du scoreboard (les nombres en rouge).
    - "smooth_experience_bar" (défaut: off) - Activer/Désactiver l'animation lissée de la barre d'expérience.
    - "sort_tab_list_by_names" (défaut: off) - Activer/Désactiver le trie de la tab-list en fonction du display-name des joueurs.

#### 3. PacketWorldEnv ([class info](src/main/java/fr/speccy/azclientapi/bukkit/packets/PacketWorldEnv.java))
- **Description**: Permet de changer l'environnement du monde d'un joueur.
  ```java
  PacketWorldEnv.setWorldEnv(Player player, String env)
  ```
  >Env: `NETHER` , `NORMAL` or `THE_END`

#### 4. PacketVignette ([class info](src/main/java/fr/speccy/azclientapi/bukkit/packets/PacketVignette.java))
- **Description**: Permet de changer la vignette d'un joueur (les contours colorés sur l'écran).
  ```java
  PacketVignette.setVignette(Player player, Float red, Float green, Float blue)
  PacketVignette.resetVignette(Player player)
  ```
  >RGB Format: [RGB Color Codes](https://htmlcolorcodes.com/fr/)

#### 5. PacketPlayerModel ([class info](src/main/java/fr/speccy/azclientapi/bukkit/packets/PacketPlayerModel.java))
- **Description**: Permet de changer le modèle d'un joueur (pour l'afficher comme étant un zombie par exemple).
  ```java
  PacketPlayerModel.setPlayerModel(Player player, Integer entityID)
  PacketPlayerModel.resetPlayerModel(Player player)
  ```
  >Entity ID: [Mobs and Entities](https://minecraft-ids.grahamedgecombe.com/entities)

#### 6. PacketEntityMeta ([class info](src/main/java/fr/speccy/azclientapi/bukkit/packets/PacketEntityMeta.java))
- **Description 1**: Permet de changer la taille d'un joueur (Hitbox et item en main pris en charge).
  ```java
  PacketEntityMeta.setPlayerScale(Player player, Float BboxH, Float BboxW, Float RenderD, Float RenderH, Float RenderW, Boolean ScaleItems)
  PacketEntityMeta.resetPlayerScale(Player player)
  ```
  >Exemple: `setPlayerScale(player, 3.0F, 3.0F, 3.0F, 3.0F, 3.0F, true)`
- **Description 2**: Permet de changer l'opacité d'un joueur.
  ```java
  PacketEntityMeta.setPlayerOpacity(Player player, Float opacity)
  PacketEntityMeta.setNameTagOpacity(Player player, Float opacity)
  PacketEntityMeta.setSneakNameTagOpacity(Player player, Float opacity)
  
  PacketEntityMeta.resetPlayerOpacity(Player player)
  PacketEntityMeta.resetNameTagOpacity(Player player)
  PacketEntityMeta.resetSneakNameTagOpacity(Player player)
  ```
  >Opacity par défaut: `-1.0F` (Invisible: >=`1.0F`)
- **Description 3**: Permet de changer le nom d'un joueur (au dessus de la tête).
  ```java
  PacketEntityMeta.setNameTag(Player player, String tag)
  ```
  >Les codes couleurs sont pris en charge et il n'y a aucune restriction de caractère.

## Savoir si un joueur utilise le launcher
- **Description**: Permet de savoir si un joueur utilise le AZ Launcher.
  ```java
  AZPlayer.hasAZLauncher(Player player)
  ```

## Récupérer une couleur au format int (0xAARRGGBB)
- **Description**: Permet de récupérer une couleur au format `int`
  ```java
  AZManager.getColor(String hexColor)
  ```
  >Utilisation: Colorer une texture au format 0xAARRGGBB (pour les NBT tags).
