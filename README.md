# AZClientAPI
API & Plugin pour intégrer le AZ Launcher (aka Pactify Launcher).

## Features

* Intégration des inventaires transparents.
* Manipulation des packets (PLSP Protocol).
* Méthode pour savoir si un joueur utilise le launcher.
* Récupérer une couleur au format int (0xAARRGGBB).
* Manipulation des ItemStacks spéciaux (par [@THE_BATTEUR](https://github.com/THEBATTEUR)).
* Compatible avec les serveurs **1.8.8** et **1.9.4** (voir la page [releases](https://github.com/Speccy42/AZClientAPI/releases)).

## Installation
> [!WARNING]
> Plugins nécessaires: [AZClientAPI.jar](https://github.com/Speccy42/AZClientAPI/releases) et [ProtocolLib.jar](https://github.com/dmulloy2/ProtocolLib/releases) (dans votre dossier `/plugins`)
### Maven
```xml
<dependencies>
  <dependency>
    <groupId>azclientapi</groupId>
    <artifactId>AZClientAPI</artifactId>
    <version></version> <!-- dernière version -->
    <scope>system</scope>
    <systemPath></systemPath> <!-- chemin d'accès du plugin -->
  </dependency>
</dependencies>
```
### Manuel (IntelliJ IDEA)
Ajoutez [**AZClientAPI.jar**](https://github.com/Speccy42/AZClientAPI/releases) dans ``Project Structure`` > ``Libraries`` > ``New Project Library`` (+)

## Documentation
[Documentation et exemples sur le Wiki en français.](https://github.com/Speccy42/AZClientAPI/wiki)