using System.Collections;
using Unity.VisualScripting;
using UnityEngine;
using UnityEngine.SceneManagement;

public class WallCtrl : MonoBehaviour
{
    public float speed;
    private Renderer cubeRenderer;

    private void Awake()
    {
        cubeRenderer = GetComponentInChildren<Renderer>();
    }

    private void Start()
    {

        int random_Speed = Random.Range(-6, -3);

        switch (random_Speed)
        {
            case -6:
                cubeRenderer.material.color = Color.red;
                break;
            case -5:
                cubeRenderer.material.color = Color.green;
                break;
            case -4:
                cubeRenderer.material.color = Color.blue;
                break;
        }
        speed = random_Speed;

        Destroy(this.gameObject, 5.0f);
    }
        void Update()
        {
            this.transform.Translate(speed * Time.deltaTime, 0, 0);
        }

}
