[doc](../../../index.md) / [org.snakeskin.dsl](../../index.md) / [HumanControls](../index.md) / [Attack3Builder](./index.md)

# Attack3Builder

`class Attack3Builder : Builder<`[`Attack3`](../../../org.snakeskin.controls.mappings/-attack3/index.md)`>, `[`ControlsBuilder`](../-controls-builder/index.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Attack3Builder(attack3: `[`Attack3`](../../../org.snakeskin.controls.mappings/-attack3/index.md)`)` |

### Properties

| Name | Summary |
|---|---|
| [Axes](-axes.md) | `val Axes: `[`AxesDefinitions`](../../../org.snakeskin.controls.mappings/-attack3/-mapping-definitions/-axes-definitions/index.md) |
| [Buttons](-buttons.md) | `val Buttons: `[`ButtonsDefinitions`](../../../org.snakeskin.controls.mappings/-attack3/-mapping-definitions/-buttons-definitions/index.md) |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`Attack3`](../../../org.snakeskin.controls.mappings/-attack3/index.md) |

### Inherited Functions

| Name | Summary |
|---|---|
| [deadbandAxis](../-controls-builder/deadband-axis.md) | `fun deadbandAxis(axis: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, deadband: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [invertAxis](../-controls-builder/invert-axis.md) | `fun invertAxis(axis: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [invertButton](../-controls-builder/invert-button.md) | `fun invertButton(button: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [scaleAxis](../-controls-builder/scale-axis.md) | `fun scaleAxis(axis: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, scaling: Scalar): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [whenButton](../-controls-builder/when-button.md) | `fun whenButton(button: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, setup: `[`ButtonHandlerBuilder`](../-button-handler-builder/index.md)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [whenHatChanged](../-controls-builder/when-hat-changed.md) | `fun whenHatChanged(hat: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, action: (newValue: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): (`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
