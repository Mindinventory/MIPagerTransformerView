<a href="https://www.mindinventory.com/?utm_source=gthb&utm_medium=repo&utm_campaign=miPagerTransformerView"><img src="https://github.com/Sammindinventory/MindInventory/blob/main/Banner.png"></a>
# MIPagerTransformerView  [![](https://jitpack.io/v/Mindinventory/MIPagerTransformerView.svg)](https://jitpack.io/#Mindinventory/MIPagerTransformerView) ![](https://img.shields.io/github/languages/top/Mindinventory/MIPagerTransformerView) ![](https://img.shields.io/github/license/mindinventory/MIPagerTransformerView)
--
MIPagerTransformer is an android library that provides a seamless image transformation experience.

## Overview
<table>
  <tr>
    <td><img src="miPagerTransformer/src/main/media/style0.gif" width=270 height=480></td>
    <td><img src="miPagerTransformer/src/main/media/style1.gif" width=270 height=480></td>
    <td><img src="miPagerTransformer/src/main/media/style2.gif" width=270 height=480></td>
  </tr>
  <tr>
    <td align="center">&#x1F446 Shutter</td>
    <td align="center">&#x1F446 Parallax</td>
    <td align="center">&#x1F446 Fold N Open</td>
  </tr>
  <tr>
    <td><img src="miPagerTransformer/src/main/media/style3.gif" width=270 height=480></td>
    <td><img src="miPagerTransformer/src/main/media/style4.gif" width=270 height=480></td>
    <td><img src="miPagerTransformer/src/main/media/style5.gif" width=270 height=480></td>
  </tr>
  <tr>
    <td align="center">&#x1F446 Strings Left</td>
    <td align="center">&#x1F446 Card Draw</td>
    <td align="center">&#x1F446 Clock Spin</td>
  </tr>
  <tr>
    <td><img src="miPagerTransformer/src/main/media/style6.gif" width=270 height=480></td>
    <td><img src="miPagerTransformer/src/main/media/style7.gif" width=270 height=480></td>
    <td><img src="miPagerTransformer/src/main/media/style8.gif" width=270 height=480></td>
  </tr>
   <tr>
    <td align="center">&#x1F446 Frame By Frame</td>
    <td align="center">&#x1F446 Counter Clock Spin</td>
    <td align="center">&#x1F446 Over Spin</td>
  </tr>
  <tr>
    <td><img src="miPagerTransformer/src/main/media/style9.gif" width=270 height=480></td>
    <td><img src="miPagerTransformer/src/main/media/style10.gif" width=270 height=480></td>
  </tr>
   <tr>
    <td align="center">&#x1F446 Strings Right</td>
    <td align="center">&#x1F446 Dual Shutter</td>
  </tr>
</table>

## Features
- Quick setup
- Multiple transition styles to choose from

## Usage
### Dependencies
- **Step 1: Add the JitPack repository in your project build.gradle file**
```bash
allprojects {
	    repositories {
		    ...
		    maven { url 'https://jitpack.io' }
	    }
    }
```
**or**

**If Android studio version is Arctic Fox or higher then add it in your settings.gradle**

```bash
dependencyResolutionManagement {
  		repositories {
       		...
       		maven { url 'https://jitpack.io' }
   		}
   }
``` 
- **Step 2: Add the dependency in your app module build.gradle file**
```bash
dependencies {
		    ...
	        implementation 'com.github.Mindinventory:MIPagerTransformerView:x.x.x'
	}
```
### Implementation

- **Step 1: Add MatchView in your xml and customize attributes**
 ```bash
<com.mindinventory.mipagertransformer.MIPagerTransformerView
        android:id="@+id/miPagerTransformerView"
        android:layout_width="match_parent"
        android:layout_height="500dp" />
```

**Step 2: Provide drawable list to MIPagerTransformerItem ArrayList**
```bash
val transformerItems: ArrayList<MIPagerTransformerItem> = ArrayList()
image1?.let { transformerItems.add(MIPagerTransformerItem(image1, "Image 1 Trees")) }
image2?.let { transformerItems.add(MIPagerTransformerItem(image2, "Image 2 Mountains")) }
```

**Step 3: Customize as per your requirement**
```bash
miPagerTransformerView.setShowDivider(true, Color.CYAN)        
// Styling of the images can be done with the Transformer option
miPagerTransformerView.setPageTransformer(Transformer.SHUTTER)
```

## Guideline for contributors
Contribution towards our repository is always welcome, we request contributors to create a pull
request to the develop branch only.

## Guideline to report an issue/feature request
It would be great for us if the reporter can share the below things to understand the root cause of
the issue.

* Library version
* Code snippet
* Logs if applicable
* Device specification like (Manufacturer, OS version, etc)
* Screenshot/video with steps to reproduce the issue

## Requirements
* minSdkVersion >= 21
* Androidx

## LICENSE!
MIPagerTransformerView is [MIT-licensed](/LICENSE).

## Let us know!
We’d be really happy if you send us links to your projects where you use our component. Just send an email to sales@mindinventory.com And do let us know if you have any questions or suggestion regarding our work.

<a href="https://www.mindinventory.com/contact-us.php?utm_source=gthb&utm_medium=repo&utm_campaign=miPagerTransformerView">
<img src="https://github.com/Sammindinventory/MindInventory/blob/main/hirebutton.png" width="203" height="43"  alt="app development">
</a>


